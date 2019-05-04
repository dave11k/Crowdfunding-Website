package ie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.Id;

@Entity
public class Pledge {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pledgeId;
	@Column(nullable=false)
	private int pledgeAmount;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="projectId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;
	
	
	public Pledge() {}
	
	public Pledge(Member member, Project project, int pledgeAmount) {
		super();
		this.pledgeAmount = pledgeAmount;
		this.member = member;
		this.project = project;
	}
	
	public int getPledgeId() {
		return pledgeId;
	}
	public void setPledgeId(int pledgeId) {
		this.pledgeId = pledgeId;
	}	
	
	public int getPledgeAmount() {
		return pledgeAmount;
	}
	public void setPledgeAmount(int pledgeAmount) {
		this.pledgeAmount = pledgeAmount;
	}

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
}
