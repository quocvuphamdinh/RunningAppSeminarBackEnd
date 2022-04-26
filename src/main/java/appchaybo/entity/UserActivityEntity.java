package appchaybo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_activity")
public class UserActivityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "run_id")
    private RunEntity userRunning;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private ActivityEntity activity;
    
    @Column
    private String comment;
    
    @Column
    private Integer mood;

	public RunEntity getUserRunning() {
		return userRunning;
	}

	public void setUserRunning(RunEntity userRunning) {
		this.userRunning = userRunning;
	}

	public ActivityEntity getActivity() {
		return activity;
	}

	public void setActivity(ActivityEntity activity) {
		this.activity = activity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getMood() {
		return mood;
	}

	public void setMood(Integer mood) {
		this.mood = mood;
	}

	public Long getId() {
		return id;
	}
    
    
}
