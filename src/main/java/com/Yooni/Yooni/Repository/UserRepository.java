package com.Yooni.Yooni.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Yooni.Yooni.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByIdIs(Long Id);
	
	User findByUsernameIs(String username);
	
	@Transactional
    @Query(value="SELECT privilege from User WHERE id = :id")
	int getUserPriviege(Long id);
	
}
