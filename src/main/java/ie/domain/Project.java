package ie.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.Id;


@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId;
	
	@Column(nullable=false)
	@Size(min=2, max=20)
	private String projectName;
	@Column(nullable=false)
	@Size(min=6, max=20)
	private String description;
	@Column(nullable=false)
	private int targetAmount;
	private LocalDate dateCreation;
	@Column(nullable=false)
	private String status;

	@OneToMany(mappedBy = "project", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Pledge> pledges = new ArrayList<Pledge>();
	
	@ManyToOne
	@JoinColumn(name="memberId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member member;
	
	
	public Project() {}


	public Project(String projectName, String description, int targetAmount, LocalDate dateCreation,
			Member member) {
		super();
		this.projectName = projectName;
		this.description = description;
		this.targetAmount = targetAmount;
		this.dateCreation = dateCreation;
		this.status = "Open";
		this.member = member;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String name) {
		this.projectName = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getTargetAmount() {
		return targetAmount;
	}


	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}


	public LocalDate getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}


	public List<Pledge> getPledges() {
		return pledges;
	}


	public void addPledge(Pledge pledge) {
		pledges.add(pledge);
	}


	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}
	
	
	public void isTargetAchieved(int pledgeAmount) {
		int total = 0;
		for(Pledge pledge : pledges) {
			total += pledge.getPledgeAmount();
		}
		if((total + pledgeAmount) >= targetAmount) {
			status = "Closed";
		}
	}
	
	
	
}
