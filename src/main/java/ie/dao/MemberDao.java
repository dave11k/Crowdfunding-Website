package ie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.domain.Member;


public interface MemberDao extends JpaRepository<Member, Integer>{

	boolean existsByMemberName(String memberName);

	Member findByMemberName(String memberName);

	
}
