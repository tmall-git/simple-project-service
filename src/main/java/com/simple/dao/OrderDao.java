package com.simple.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.Order;
import com.simple.model.SellerListVO;
import com.simple.model.User;

@Repository
@DatabaseTemplate("st_all")
public class OrderDao extends BaseIbatisDao{
	
	public List<Order> getOrdersByUserPhone(Map<String, Object> param){
		return this.sqlSession.selectList("order.queryByUserPhone",param);
	}
	
	public Integer getOrdersCount(Map<String, Object> param){
		return this.sqlSession.selectOne("order.queryOrderCount",param);
	}
	
	public Order getById(int id){
		return this.sqlSession.selectOne("order.getById",id);
	}
	
	public double queryTotalPrice(String owner) {
		return this.sqlSession.selectOne("order.queryTotalPrice",owner);
	}
	
	public double queryTotalCharge(String owner) {
		return this.sqlSession.selectOne("order.queryTotalCharge",owner);
	}
	
	public int queryCountByStatus(String owner,int orderStatus,int changeStatus,int rejectStatus,int payStatus) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("order_status", orderStatus);
		param.put("change_status", changeStatus);
		param.put("reject_status", rejectStatus);
		param.put("pay_status", payStatus);
		param.put("userPhone", owner);
		return this.sqlSession.selectOne("order.queryCountByStatus",param);
	}
	
	public void addOrder(Order order) {
		this.sqlSession.insert("order.insert",order);
	}
	
	public void updateOrderStatus(Order order) {
		this.sqlSession.update("order.updateOrderStatus",order);
	}
	
	public void updateRejectStatus(Order order){
		this.sqlSession.update("order.updateReject",order);
	}
	
	public void changeProduct(Order order) {
		this.sqlSession.update("order.changeProduct",order);
	}
	
	public void reject(Order order) {
		this.sqlSession.update("order.reject",order);
	}
	
	public void payOrder(Order order) {
		this.sqlSession.update("order.payOrder",order);
	}
	
	public void updateExpressage(Order order) {
		this.sqlSession.update("order.updateExpressage",order);
	}

	public Map<String, Object> getTotalSellerAmount(User user) {
		return this.sqlSession.selectOne("order.getTotalSellerAmount",user);
	}
	
	public List<SellerListVO> getSellerList(User user) {
		return this.sqlSession.selectList("order.getSellerList",user);
	}

}
