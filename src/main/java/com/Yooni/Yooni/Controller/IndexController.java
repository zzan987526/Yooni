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
import org.springframework.web.bind.annotation.RestController;

import com.Yooni.Yooni.Entity.order;
import com.Yooni.Yooni.Service.impl.OrderServiceImpl;

@RestController
@RequestMapping("/api")
public class IndexController {
	@Autowired
	private OrderServiceImpl ordS;
	
	@RequestMapping(value="/listord")
	public List<order> ListOrders(){
		return ordS.GetOrders();
	}
	
	@RequestMapping(value="/addord")
	public Map<String, Object> addOrd(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();	
		String message = null;
		Long uid = Long.parseLong(request.getParameter("uid"));
		String title = request.getParameter("title");
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
		order ord = new order(uid,title,Content,price,state,req,cur,destime);
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

}
