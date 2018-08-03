package com.Yooni.Yooni.Service;

import java.util.List;

import com.Yooni.Yooni.Entity.order;

public interface OrderService {

	public List<order> GetOrders();
	public order GetOrder(Long id);
	public boolean addOrder(order ord);
	public void updateCur(Long id);
	
}
