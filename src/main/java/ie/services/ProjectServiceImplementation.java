package ie.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dao.*;
import ie.domain.*;


@Service
public class ProjectServiceImplementation implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	@Autowired
	MemberService memberService;
	
	
	@Override
	public List<Project> listAllProjects() {
		// TODO Auto-generated method stub
		return projectDao.findAll();
	}
	
	@Override
	public Project findProject(int id) {
		if(projectDao.existsById(id)) {
			return projectDao.findById(id).get();
		}
		return null;
	}
	
	@Override
	public Project findByName(String projectName) {
		if(projectDao.existsByProjectName(projectName))
			return projectDao.findByProjectName(projectName);
		return null;
	}
	
	@Override
	public boolean deleteProject(int id) {
		if (projectDao.existsById(id))
		{
			projectDao.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addProject(Project project) { //Create a project, save it to projectDao and add project to list of projects for that user
		//if(memberService.isUserAuthenticated(project.getMember().getMemberId())) {	//First check if member is authenticated to create a project
			projectDao.save(project);
			//memberService.addProject(project.getMember().getMemberId(), project);
			return true; //When project is added successfully return true
		//}
		//return false; //Else return false
	}
	
	@Override
	public String findProjectName(int id) {
		if (projectDao.existsById(id))
			return projectDao.findNameById(id);
		return null;
	}
	
	@Override
	public String findProjectDesc(int id) {
		if(projectDao.existsById(id))
			return projectDao.findDescriptionById(id);
		return null;
	}
	
	@Override
	public int findProjectTargetAmount(int id) {
		if(projectDao.existsById(id))
			return projectDao.findTargetAmount(id);
		return 0;
	}
	
	@Override
	public LocalDate findProjectDateCreation(int id) {
		if(projectDao.existsById(id))
			return projectDao.findDateCreation(id);
		return null;
	}

	@Override
	public List<Pledge> findAllPledgesForProject(int projectId){	//List all pledges for a project
		if(projectDao.existsById(projectId)){
			return findProject(projectId).getPledges();
		}
		return null;
	}
	
	@Override
	public boolean editDescription(int projectId, String description) { 	//Edit the current description of a project given a new description
		if(projectDao.existsById(projectId)){
			Project project = findProject(projectId);
			project.setDescription(description);
			projectDao.save(project);
			return true;
		}
		
		//save project***************
		return false;
	}
	
		
	
}




