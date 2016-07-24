package com.simple.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.Order;
import com.simple.model.SellerListVO;
import com.simple.model.SellerMainVO;
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
	
	public Order getByCode(String code){
		return this.sqlSession.selectOne("order.getByCode",code);
	}
	
	public Double queryAgentTotalPrice(String owner,String begin,String end) {
		Map param = new HashMap();
		param.put("owner", owner);
		param.put("beginTime", begin);
		param.put("endTime", end);
		return this.sqlSession.selectOne("order.queryAgentTotalPrice",param);
	}
	
	public Double queryAgentTotalCharge(String owner,String begin,String end) {
		Map param = new HashMap();
		param.put("owner", owner);
		param.put("beginTime", begin);
		param.put("endTime", end);
		return this.sqlSession.selectOne("order.queryAgentTotalCharge",param);
	}
	
	public Double querySellerTotalPrice(String owner,String seller,String begin,String end) {
		Map param = new HashMap();
		param.put("owner", owner);
		param.put("seller", seller);
		param.put("beginTime", begin);
		param.put("endTime", end);
		return this.sqlSession.selectOne("order.querySellerTotalPrice",param);
	}
	
	public Double querySellerTotalCharge(String owner,String seller) {
		Map param = new HashMap();
		param.put("owner", owner);
		param.put("seller", seller);
		return this.sqlSession.selectOne("order.querySellerTotalCharge",param);
	}
	
	public Integer queryCountByStatus(String owner,String seller,int orderStatus,String begin,String end) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("order_status", orderStatus);
		param.put("owner", owner);
		param.put("seller", seller);
		param.put("beginTime", begin);
		param.put("endTime", end);
		return this.sqlSession.selectOne("order.queryCountByStatus",param);
	}
	
	public List<Order> queryListByStatus(String owner,String seller,int orderStatus,
			String begin,String end,int pageIndex,int pageSize) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("order_status", orderStatus);
		param.put("owner", owner);
		param.put("seller", seller);
		param.put("beginTime", begin);
		param.put("endTime", end);
		if (pageIndex <=0) {
			pageIndex = 1;
		}
		param.put("begin", (pageIndex-1)*pageSize);
		param.put("size", pageSize);
		return this.sqlSession.selectList("order.queryListByStatus",param);
	}
	
	public List<Order> queryToDoList(String owner,String seller,String begin,String end,int pageIndex,int pageSize) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("owner", owner);
		param.put("seller", seller);
		param.put("beginTime", begin);
		param.put("endTime", end);
		if (pageIndex <=0) {
			pageIndex = 1;
		}
		param.put("begin", (pageIndex-1)*pageSize);
		param.put("size", pageSize);
		return this.sqlSession.selectList("order.queryToDoList",param);
	}
	
	public Integer queryProductCount(String owner,String seller,int orderStatus) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("order_status", orderStatus);
		param.put("owner", owner);
		param.put("seller", seller);
		return this.sqlSession.selectOne("order.queryCountByStatus",param);
	}
	
	public void addOrder(Order order) {
		this.sqlSession.insert("order.insert",order);
	}
	
	public int sendOrder(Order order) {
		return this.sqlSession.update("order.sendOrder",order);
	}
	
	public int reject(Order order) {
		return this.sqlSession.update("order.updateReject",order);
	}
	
	public int rejectRefuse(Order order) {
		return this.sqlSession.update("order.updateRejectRefuse",order);
	}
	
	public int cancel(Order order) {
		return this.sqlSession.update("order.updateCancel",order);
	}
	
	public void payOrder(Order order) {
		this.sqlSession.update("order.payOrder",order);
	}

}
