package com.Yooni.Yooni.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Yooni.Yooni.Entity.order;

public interface OrderRepository extends JpaRepository<order, Long> {

	order findByIdIs(Long id);
	
	List<order> findByStateIs(Integer state);
	
	@Transactional
    @Query(value="UPDATE order ord SET ord.cur = ord.cur+1 WHERE ord.id= :id")
    int  updateOrderCur(@Param("id")Long id);
	
}
