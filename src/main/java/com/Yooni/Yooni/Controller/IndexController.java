package com.Yooni.Yooni.Controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Yooni.Yooni.Common.Constants;
import com.Yooni.Yooni.Entity.User;
import com.Yooni.Yooni.Entity.comment;
import com.Yooni.Yooni.Entity.order;
import com.Yooni.Yooni.Service.impl.CommentServiceImpl;
import com.Yooni.Yooni.Service.impl.OrderServiceImpl;
import com.Yooni.Yooni.Service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class IndexController {
	@Autowired
	private OrderServiceImpl ordS;
	
	@Autowired
	private CommentServiceImpl ComS;
	
	@Autowired
	private UserServiceImpl UserS;
	
	@RequestMapping(value="/listord")
	public List<order> ListOrders(){
		return ordS.GetOrders();
	}
	
	@RequestMapping(value="/addord")
	public Map<String, Object> addOrd(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();	
		String message = null;
		String token = request.getHeader("Api-Token");
		Long uid = UserS.GetUidByToken(token);
		String uname = UserS.FindUser(uid).getUsername();
		String title = request.getParameter("title");
		String ordpic = request.getParameter("ordpic");
		String Content = request.getParameter("content");
		Integer price = Integer.parseInt(request.getParameter("price"));
		Integer state = Integer.parseInt(request.getParameter("state"));
		Integer req = Integer.parseInt(request.getParameter("req"));
		Integer cur = Integer.parseInt(request.getParameter("cur"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date destime;
		try {
			destime = sdf.parse(request.getParameter("destime"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", -1);
			message = "添加失败";
			map.put("message", message);
			return map;
		}
		order ord = new order(uid,uname,title,ordpic,Content,price,state,req,cur,destime);
		boolean bAdd = ordS.addOrder(ord);
		if(bAdd) {
			message = "success";
			map.put("code", 0);
			map.put("message", message);
		}
		else {
			map.put("code", -1);
			message = "添加失败";
			map.put("message", message);
			
		}
		return map;
	}
	
	@RequestMapping(value="/listcom")
	public List<comment> listComments(){
		System.out.println(ComS.GetComments(1l).get(0));
		return ComS.GetComments(1l);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Map<String, Object> Login(@RequestParam String username,@RequestParam String password){
		Map<String,Object> map = new HashMap<>();
		System.out.println(username);
		System.out.println(password);
		User user = UserS.FindUser(username);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				String token = UserS.CreateToken(user.getId());
				map.put("code", 0);
				map.put("message", token);
			}
			else {
				map.put("code", -1);
				map.put("message", "账户密码错误");
			}
		} else {
			map.put("code", -1);
			map.put("message", "账户密码错误");
		}
		
		return map;
	}
	
	@RequestMapping(value="/register")
	public Map<String, Object> register(@RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String passWord,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "Phone", required = true) String phone){
		Map<String,Object> map = new HashMap<>();
		User u = UserS.FindUser(userName);
		if(u != null) {
			map.put("code", -1);
			map.put("message", "用户名已存在");
			return map;
		}
		int privilege = Constants.NORMAL_USER;
		String Avatar = Constants.DEFUALT_AVATAR;
		int credit = Constants.DEFAULT_CREDIT;
		u = new User(userName,passWord,userName,email,credit,Avatar,phone,privilege);
		u = UserS.addUser(u);
		map.put("code", 0);
		map.put("message", "success");
		map.put("userid", u.getId());
		return map;
	}
}
