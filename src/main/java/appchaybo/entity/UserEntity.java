package appchaybo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column
	private String avartar;
	
	@Column
	private String gender;
	
	@Column
	private Integer weight;
	
	@Column
	private Integer height;
	
	@Column
	private Long distanceGoal;

//	@ManyToMany
//	@JoinTable(name="user_running", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "run_id"))
//	private List<RunEntity>runEntities = new ArrayList<RunEntity>();
//	
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
	
	@OneToMany(mappedBy = "user")
	private List<RunEntity>runEntities = new ArrayList<RunEntity>();
	
	public List<RunEntity> getRunEntities() {
		return runEntities;
	}

	public void setRunEntities(List<RunEntity> runEntities) {
		this.runEntities = runEntities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Long getId() {
		return id;
	}
	
	
}
