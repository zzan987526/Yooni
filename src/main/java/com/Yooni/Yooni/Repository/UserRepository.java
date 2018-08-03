package com.Yooni.Yooni.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Yooni.Yooni.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByIdIs(Long Id);
	
	User findByUsernameIs(String username);
	
	
}
