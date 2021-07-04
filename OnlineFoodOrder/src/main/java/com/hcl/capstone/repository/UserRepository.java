package com.hcl.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.capstone.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="select * from user where email=?", nativeQuery=true)
	User findByEmail(String email);

	@Query(value="select * from user where email=? and password=?", nativeQuery=true)
	User getUserByEmailAndPassword(String email, String password);

}
