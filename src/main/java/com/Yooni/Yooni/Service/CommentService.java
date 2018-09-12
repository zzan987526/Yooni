package com.Yooni.Yooni.Service;

import java.util.List;

import com.Yooni.Yooni.Entity.comment;

public interface CommentService {

	public List<comment> GetComments(Long oid);
	
}
