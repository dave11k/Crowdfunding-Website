package ie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.domain.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
