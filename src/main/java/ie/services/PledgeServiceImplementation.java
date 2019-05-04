package ie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dao.*;
import ie.domain.*;


@Service
public class PledgeServiceImplementation implements PledgeService {

	@Autowired
	PledgeDao pledgeDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	ProjectDao projectDao;
	@Autowired
	ProjectService projectService;
	@Autowired
	MemberService memberService;
	
	
	@Override
	public Pledge findPledge(int id) {
		if(pledgeDao.existsById(id)) {
			return pledgeDao.findById(id).get();
		}
		return null;
	}
	
	@Override
	public boolean deletePledge(int id) {
		if (pledgeDao.existsById(id))
		{
			pledgeDao.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public Pledge addPledge(Pledge pledge) {
		if(pledge.getProject().getStatus().equals("Closed")) {
			return null; //If the project is already closed return null
		}
		//if it's open, save the pledge and change to project to closed of the target amount is met
		pledgeDao.save(pledge);	
		pledge.getProject().isTargetAchieved(pledge.getPledgeAmount());
		
		int total = 0;
		for(Pledge temp : pledge.getProject().getPledges()) {
			total += temp.getPledgeAmount();
		}
		if((total + pledge.getPledgeAmount()) >= pledge.getProject().getTargetAmount()) {
			pledge.getProject().setStatus( "Closed");
		}
		projectDao.save(pledge.getProject());
		
		return pledge;
	}
	
	@Override
	public List<Pledge> findAllPledgesForProject(int projectId) {
		if(projectDao.existsById(projectId)) {
			List<Pledge> pledges = pledgeDao.findByProject_ProjectId(projectId);
			return pledges;
		}
	
		return null;
	}
	
	
}
