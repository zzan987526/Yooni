package com.Yooni.Yooni.Service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yooni.Yooni.Entity.User;
import com.Yooni.Yooni.Repository.UserRepository;
import com.Yooni.Yooni.Service.UserService;
import com.Yooni.Yooni.Util.ApiToken;
import com.nimbusds.jose.JOSEException;

import net.minidev.json.JSONObject;

import com.Yooni.Yooni.Common.*;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository UserRepo;
	
	
	
	@Override
	public User FindUser(Long id) {
		// TODO Auto-generated method stub
		return UserRepo.findByIdIs(id);
	}

	@Override
	public User FindUser(String username) {
		// TODO Auto-generated method stub
		return UserRepo.findByUsernameIs(username);
	}

	@Override
	public List<User> FindAllUser() {
		// TODO Auto-generated method stub
		return UserRepo.findAll();
	}

	@Override
	public String CreateToken(Long uid) {
		Map<String, Object> map = new HashMap<>();
		map.put("uid", uid);
		Date date = new Date();
		map.put("start", date.getTime());
		map.put("exp", date.getTime() + Constants.EXPRIED_TIME);
		try {
			String token = ApiToken.creatToken(map);
			return token;
		} catch (JOSEException e) {
			System.out.println("生成token失败");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean CheckToken(String token) {
		
		if(token != null) {
			try {
				Map<String,Object> map = ApiToken.valid(token);
				int i = (int)map.get("Result");
				System.out.println(i);
				if(i == 0) {
					//JSONObject jsonObject = (JSONObject) map.get("data");
					return true;
				}
				
			} catch (ParseException | JOSEException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return false;
	}

	@Override
	public User addUser(User u) {
		User re = UserRepo.save(u);
		return re;
	}

	@Override
	public Long GetUidByToken(String token) {
		// TODO Auto-generated method stub
		if(token != null) {
			try {
				Map<String,Object> map = ApiToken.valid(token);
				int i = (int)map.get("Result");
				System.out.println(i);
				if(i == 0) {
					JSONObject jsonObject = (JSONObject) map.get("data");
					return (Long) jsonObject.get("uid");
				}
				
			} catch (ParseException | JOSEException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return -1l;
	}
	
	

}
