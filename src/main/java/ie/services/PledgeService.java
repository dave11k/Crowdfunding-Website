package ie.services;

import java.util.List;

import ie.domain.Pledge;

public interface PledgeService {

	boolean deletePledge(int id);
	Pledge findPledge(int id);
	Pledge addPledge(Pledge pledge);
	List<Pledge> findAllPledgesForProject(int projectId);

	
	
}
