package com.Yooni.Yooni.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Yooni.Yooni.Entity.comment;

public interface CommentRepository extends JpaRepository<comment, Long> {

	List<comment> findByOrdIdIs(Long oid);
	
}
