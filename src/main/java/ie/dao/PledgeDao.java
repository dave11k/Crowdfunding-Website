package ie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.domain.Pledge;

public interface PledgeDao extends JpaRepository<Pledge, Integer>{

	List<Pledge> findByProject_ProjectId(int projectId);


}
