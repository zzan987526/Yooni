package com.Yooni.Yooni.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yooni.Yooni.Entity.order;
import com.Yooni.Yooni.Repository.OrderRepository;
import com.Yooni.Yooni.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository ordRepo;
	
	@Override
	public List<order> GetOrders() {
				
		return ordRepo.findAll();
	}

	@Override
	public order GetOrder(Long id) {
		
		return ordRepo.findByIdIs(id);
	}

	@Override
	public boolean addOrder(order ord) {
		boolean result = true;
		try {
			ordRepo.save(ord);
		}catch(Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public void updateCur(Long id) {
		ordRepo.updateOrderCur(id);
	}
	
}
