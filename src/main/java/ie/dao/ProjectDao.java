package ie.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.domain.Project;


public interface ProjectDao extends JpaRepository<Project, Integer>{

	boolean existsByProjectName(String projectName);
	Project findByProjectName(String projectName);
	
	@Query("SELECT p.projectName FROM Project p where p.projectId = :id") 
	String findNameById(@Param("id") int id);
	
	@Query("SELECT p.description FROM Project p where p.projectId = :id") 
	String findDescriptionById(@Param("id")int id);

	@Query("SELECT p.targetAmount FROM Project p where p.projectId = :id") 
	int findTargetAmount(@Param("id") int id);
	
	@Query("SELECT p.dateCreation FROM Project p where p.projectId = :id") 
	LocalDate findDateCreation(@Param("id") int id);
	

	
}




