package ie.services;

import java.time.LocalDate;
import java.util.List;

import ie.domain.Pledge;
import ie.domain.Project;

public interface ProjectService {

	List<Project> listAllProjects();

	Project findProject(int id);

	Project findByName(String projectName);

	boolean deleteProject(int id);

	LocalDate findProjectDateCreation(int id);

	int findProjectTargetAmount(int id);
	String findProjectDesc(int id);
	String findProjectName(int id);


	boolean addProject(Project project);

	List<Pledge> findAllPledgesForProject(int projectId);

	boolean editDescription(int projectId, String description);

	
}
