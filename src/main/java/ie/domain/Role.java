package ie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	String memberEmail;
	@Column
	String roleDescription;
	// usual methods
	
	
	
	public String getUserEmail() {
		return memberEmail;
	}
	public Role() {
		super();
	}
	
	public Role(String memberEmail, String roleDescription) {
		super();
		this.memberEmail = memberEmail;
		this.roleDescription = roleDescription;
	}
	
	public void setUserEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
}