package appchaybo.dto;

public class UserDTO extends AbstractDTO<UserDTO>{
	
	private String userName;
	private String passWord;
	private String fullName;
	private String avartar;
	private String gender;
	private Integer weight;
	private Integer height;
	private Long distanceGoal;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String userName, String passWord, String fullName, String avartar, String gender, Integer weight,
			Integer height, Long distanceGoal) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.avartar = avartar;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.distanceGoal = distanceGoal;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Long getDistanceGoal() {
		return distanceGoal;
	}
	public void setDistanceGoal(Long distanceGoal) {
		this.distanceGoal = distanceGoal;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAvartar() {
		return avartar;
	}
	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}
	
	
}
