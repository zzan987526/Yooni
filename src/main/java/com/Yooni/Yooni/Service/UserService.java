package com.Yooni.Yooni.Service;

import java.util.List;

import com.Yooni.Yooni.Entity.User;

public interface UserService {

	public User FindUser(Long id);
	public User FindUser(String username);
	public List<User> FindAllUser();
	
}
