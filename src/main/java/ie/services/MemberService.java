package ie.services;

import java.time.LocalDate;
import java.util.List;

import ie.domain.Member;
import ie.domain.Project;

public interface MemberService {

	Member findMember(int id);
	Member findByName(String memberName);
	boolean deleteMember(int id);
	boolean registerUser(String name, String email, String password);
	void addProject(Member member, Project project);
	List<Project> findAllProjectsForMember(int memberId);

	
	
}
