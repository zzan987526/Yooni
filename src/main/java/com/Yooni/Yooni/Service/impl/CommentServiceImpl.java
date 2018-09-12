package com.Yooni.Yooni.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yooni.Yooni.Entity.comment;
import com.Yooni.Yooni.Repository.CommentRepository;
import com.Yooni.Yooni.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository ComRepo;
	
	@Override
	public List<comment> GetComments(Long oid) {
		
		return ComRepo.findByOrdIdIs(oid);
	}

}
