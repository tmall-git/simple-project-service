package com.simple.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.dao.OrderDao;
import com.simple.dao.ProductDao;
import com.simple.model.Order;
import com.simple.model.PageResult;
import com.simple.model.Product;
@Service
public class OrderService {
	
	private final int ORDER_SEND = 2; 
	private final int ORDER_SENDED = 3; 
	private final int ORDER_FINISHED = 3; 
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	public Order getOrdersById(int id) {
		return orderDao.getById(id);
	}
	
	public boolean updateProductToSend(int orderId){
		try {
			// 修改订单状态
			Order order = orderDao.getById(orderId);
			if(order == null){
				throw new Exception("该订单不存在");
			}
			order.setOrder_status(ORDER_SENDED);
			order.setExpressage_time(new Date());
			orderDao.updateOrderStatus(order);
			// 扣减库存
			int goodsId = order.getProduct_id();
			Product product = productDao.getById(goodsId);
			int oldStack = product.getStock();
			if(oldStack <= 0){
				throw new Exception("该商品没有库存");
			}
			product.setStock(oldStack - 1);
			productDao.updateProduct(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean updateReturnProduct(int orderId, int returnStatus, String remark) {
		try {
			Order order = orderDao.getById(orderId);
			order.setOrder_status(ORDER_FINISHED);
			order.setReject_status(returnStatus);
			if(returnStatus == 0){
				order.setReject_remark(remark);
			}
			orderDao.updateRejectStatus(order);
			// TODO 1、回库逻辑
			int goodsId = order.getProduct_id();
			Product product = productDao.getById(goodsId);
			product.setStock(product.getStock() + 1);
			productDao.updateProduct(product);
			// TODO 2、退款逻辑 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// TODO 换货状态不明确
	public boolean updateChangeProduct(int orderId, int returnStatus){
		try {
			Order order = orderDao.getById(orderId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Double queryAgentTotalPrice(String owner) {
		return orderDao.queryAgentTotalPrice(owner);
	}
	
	public Double queryAgentTotalCharge(String owner) {
		return orderDao.queryAgentTotalCharge(owner);
	}
	
	public Double querySellerTotalPrice(String owner,String seller,String begin,String end) {
		return orderDao.querySellerTotalPrice(owner,seller,begin,end);
	}
	
	public Double querySellerTotalCharge(String owner,String seller) {
		return orderDao.querySellerTotalCharge(owner,seller);
	}
	
	public List<Order> queryListByStatus(String owner,String seller,int orderStatus,int changeStatus,int rejectStatus,
			int payStatus,String begin,String end,int pageIndex,int pageSize) {
		return orderDao.queryListByStatus(owner,seller,orderStatus, changeStatus, rejectStatus, payStatus,begin,end,pageIndex,pageSize);
	}
	
	public List<Order> queryToDoList(String owner,String seller,String begin,String end,int pageIndex,int pageSize) {
		return orderDao.queryToDoList(owner,seller,begin,end,pageIndex,pageSize);
	}
	
	public Integer queryCountByStatus(String owner,String seller,int orderStatus,int changeStatus,int rejectStatus,int payStatus,String begin,String end) {
		return orderDao.queryCountByStatus(owner,seller,orderStatus, changeStatus, rejectStatus, payStatus,begin,end);
	}
	
	public Integer queryProductCount(String owner,String seller,int orderStatus,int changeStatus,int rejectStatus,int payStatus) {
		return orderDao.queryProductCount(owner, seller, orderStatus, changeStatus, rejectStatus, payStatus);
	}
	
}
