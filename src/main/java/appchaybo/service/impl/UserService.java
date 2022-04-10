package appchaybo.service.impl;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import appchaybo.converter.UserConverter;
import appchaybo.dto.UserDTO;
import appchaybo.entity.UserEntity;
import appchaybo.repository.UserRepository;
import appchaybo.service.IUserService;


@Service // để cho userapi hiểu để nhúng vào
public class UserService implements IUserService{
	
	
	ResourceBundle resourceBundleMail = ResourceBundle.getBundle("mail");
	
	@Autowired // nhúng repo vào service
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	private SecureRandom sRandom = new SecureRandom();

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		if(userDTO.getId()!=0L) {
			UserEntity oldUser = userRepository.findOne(userDTO.getId());
			userEntity = userConverter.toEntity(userDTO, oldUser);
		}else {
			userEntity = userConverter.toEntity(userDTO);
		}
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	@Override
	public UserDTO findOneByUsernameAndPassword(String userName, String passWord) {
		UserEntity userEntity = userRepository.findOneByUsernameAndPassword(userName, passWord);
		if(userEntity!=null) {
			return userConverter.toDTO(userEntity);
		}
		return new UserDTO("", "", "", "", "", 0, 0, 0L);
	}

	@Override
	public HashMap<String, String> resetPassword(String email) {
		UserEntity userEntity = userRepository.findOneByUsername(email);
		String newPassword = getRandomPassword(6);
		userEntity.setPassword(newPassword);
		userEntity = userRepository.save(userEntity);
//		prepare send mail
		String systemEmail = resourceBundleMail.getString("email_verify");
		String passEmail = resourceBundleMail.getString("password_verify");
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.enable", "true");
		Session sessionMail = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(systemEmail, passEmail);
			}
		});
//		send mail
		String sendTo = email;
		String emailSubject = resourceBundleMail.getString("subject_reset_password");
		String emailContent = "Your new password: " + newPassword;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		try {
			Message messageMail = new MimeMessage(sessionMail);
			messageMail.setFrom(new InternetAddress(systemEmail));
			messageMail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
			messageMail.setSubject(emailSubject);
			messageMail.setText(emailContent);
			Transport.send(messageMail);
			hashMap.put("message", "Reset password successfully");
			return hashMap;
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
		hashMap.put("message", "Failed to reset password");
		return hashMap;
	}
	
	private String getRandomPassword(Integer _lenght) {
		String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder secretPassword = new StringBuilder("");
		for (int i = 0; i < _lenght; i++) {
			int index = sRandom.nextInt(alphabet.length());
			secretPassword.append(alphabet.substring(index, index + 1));
		}
		return secretPassword.toString();
	}

	@Override
	public UserDTO checkEmailUser(String email) {
		UserEntity userEntity = userRepository.findOneByUsername(email);
		if(userEntity!=null) {
			return userConverter.toDTO(userEntity);
		}
		return new UserDTO("", "", "", "", "", 0, 0, 0L);
	}
}
