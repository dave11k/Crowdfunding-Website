package ie;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ie.dao.*;
import ie.domain.*;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	MemberDao memberDao;
	@Autowired
	PledgeDao pledgeDao;
	@Autowired
	ProjectDao projectDao;
	//@Autowired
	//PasswordEncoder passwordEncoder;
	@Autowired
	RoleDao roleDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role davidRole = new Role("david@email", "ROLE_USER");
		Role darraghRole = new Role("darragh@email", "ROLE_ADMIN");
		roleDao.save(davidRole);
		roleDao.save(darraghRole);

		Member david = new Member("david@email", "David", "password");
		Member darragh = new Member("darragh@email", "Darragh","password");

		
		Project one = new Project("Project 1", "Good project", 100, LocalDate.now(), david);
		Project two = new Project("Project 2", "bad project", 150, LocalDate.now(), david);
		
		Pledge pledgeOne = new Pledge(david, one, 30);
		Pledge pledgeTwo = new Pledge(david, one, 20);
		Pledge pledgeThree = new Pledge(david, two, 60);
		Pledge pledgeFour = new Pledge(david, two, 10);
		
		memberDao.save(david);
		memberDao.save(darragh);
		projectDao.save(one);
		projectDao.save(two);
		pledgeDao.save(pledgeOne);
		pledgeDao.save(pledgeTwo);
		pledgeDao.save(pledgeThree);
		pledgeDao.save(pledgeFour);

		
	}
}