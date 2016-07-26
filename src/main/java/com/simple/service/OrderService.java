package com.simple.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.constant.Constant;
import com.simple.dao.AgentSellerDao;
import com.simple.dao.ExpressageDao;
import com.simple.dao.OrderDao;
import com.simple.dao.ProductDao;
import com.simple.dao.UserDao;
import com.simple.model.AgentSeller;
import com.simple.model.Expressage;
import com.simple.model.Order;
import com.simple.model.OrderForm;
import com.simple.model.Product;
import com.simple.model.User;
@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ExpressageDao expressageDao;
	@Autowired
	private AgentSellerDao agentSellerDao;
	@Autowired
	private UserDao userDao;
	
	
	public Order getOrderByCode(String code) {
		return orderDao.getByCode(code);
	}
	
	public void updateOrderSend(String code,String expressCode,String expressNumber,String expressName) throws Exception{
		// 修改订单状态
		Order order = getOrderByCode(code);
		if(order == null){
			throw new Exception("该订单不存在");
		}
		order.setOrder_status(Constant.ORDER_STATUS_SEND);
		order.setExpressage_time(new Date());
		order.setExpressage_no(expressNumber);
		order.setExpressage(expressCode);
		order.setExpressage_name(expressName);
		int result = orderDao.sendOrder(order);
		if (result <=0) {
			throw new Exception("当前订单状态不是待发货状态，不能发货");
		}
	}

	
	public void updateReject(String code) throws Exception {
		//更新订单状态为完成，更新提成为0,不计入提成
		Order order = getOrderByCode(code);
		if(order == null){
			throw new Exception("该订单不存在");
		}
		//
		order.setOrder_status(Constant.ORDER_STATUS_REGECT_FINISHED);
		order.setAgent_total_charge(0d);
		order.setSeller_total_charge(0d);
		order.setReject_time(new Date());
		order.setTotal_price(0d);
		int result = orderDao.reject(order);
		if (result <=0) {
			throw new Exception("当情订单状态已完成，不能退货");
		}
		//TODO 更新商品库存+1
		/**
		int goodsId = order.getProduct_id();
		Product product = productDao.getById(goodsId);
		product.setStock(product.getStock() + 1);
		productDao.updateProduct(product);
		*/
		// TODO 退款给支付微信
		String payAccount = order.getPay_account();
	}
	
	public void updateRejectRefuse(String code,String remark) throws Exception {
		//更新订单状态为拒绝退款，
		Order order = getOrderByCode(code);
		if(order == null){
			throw new Exception("该订单不存在");
		}
		order.setOrder_status(Constant.ORDER_STATUS_REGECT_REFUSE);
		order.setReject_remark(remark);
		int result = orderDao.rejectRefuse(order);
		if (result <=0) {
			throw new Exception("当情订单状态不是退货中，不能拒绝退货");
		}
	}
	
	public void updateFinished(String code) throws Exception {
		//更新订单状态为已完成，并加提成额度到代理和代销账户
		Order order = getOrderByCode(code);
		if(order == null){
			throw new Exception("该订单不存在");
		}
		updateFinished(order);
	}
	
	public void updateFinished(Order order) throws Exception {
		//更新订单状态为已完成，并加提成额度到代理和代销账户
		order.setOrder_status(Constant.ORDER_STATUS_FINISHED);
		int result = orderDao.finish(order);
		if (result <=0) {
			throw new Exception("当情订单状态不能完成");
		}
		String owner = order.getOwner();
		String seller = order.getSeller();
		double ownercharge = order.getAgent_total_charge();
		double sellercharge = order.getSeller_total_charge();
		userDao.increseCharge(owner, ownercharge);
		userDao.increseCharge(seller, sellercharge);
	}
	
	public void updateCancel(String code) throws Exception {
		Order order = getOrderByCode(code);
		if(order == null){
			throw new Exception("该订单不存在");
		}
		updateCancel(order);
	}
	
	public void updateCancel(Order order)throws Exception {
		if ((order.getOrder_status() == Constant.ORDER_STATUS_TOSEND) || (order.getOrder_status() == Constant.ORDER_STATUS_UNPAY)) {
			order.setOrder_status(Constant.ORDER_STATUS_CANCEL);
			order.setAgent_total_charge(0d);
			order.setSeller_total_charge(0d);
			order.setReject_time(new Date());
			order.setTotal_price(0d);
			int result = orderDao.cancel(order);
			if (result <=0) {
				throw new Exception("当情订单状态不是未付款或者未发货，不能取消");
			}
			//回滚库存
			productDao.increaseStock(order.getProduct_id(), order.getProduct_count());
		}else {
			throw new Exception("取消失败：当前订单状态不可取消");
		}
	}
	
	public String addOrder(OrderForm orderForm,String seller) throws Exception  {
		Product product = productDao.getById(orderForm.getProductId());
		if ( null == product ) {
			throw new Exception("商品不存在.");
		}
		//查询代销提成比
		List<AgentSeller> ass =  agentSellerDao.queryListByPhone(product.getOwner(), seller, 1, 1);
		double percent = 0d;
		if ( null != ass && ass.size() > 0) {
			percent = ass.get(0).getChargePercent();
		}else {
			User owner = userDao.getByPhone(product.getOwner());
			if ( null == owner ) {
				throw new Exception("商品所属用户不存在");
			}
			percent = owner.getChargePrecent();
		}
		//扣商品库存
		int stock = productDao.reduceStock(product.getId(),orderForm.getProductCount());
		if (stock<=0) {
			throw new Exception("商品库存不足!");
		}
		Order order = orderForm.castToOrder(product, seller, percent);
		orderDao.addOrder(order);
		return order.getOrder_no();
	}
	
	public Double queryAgentTotalPrice(String owner,String begin,String end) {
		return orderDao.queryAgentTotalPrice(owner,begin,end);
	}
	
	public Double queryAgentTotalCharge(String owner,String begin,String end) {
		return orderDao.queryAgentTotalCharge(owner,begin,end);
	}
	
	public Double querySellerTotalPrice(String owner,String seller,String begin,String end) {
		return orderDao.querySellerTotalPrice(owner,seller,begin,end);
	}
	
	public Double querySellerTotalCharge(String owner,String seller) {
		return orderDao.querySellerTotalCharge(owner,seller);
	}
	
	public List<Order> queryListByStatus(String owner,String seller,int orderStatus,String begin,String end,int pageIndex,int pageSize) {
		return orderDao.queryListByStatus(owner,seller,orderStatus, begin,end,pageIndex,pageSize);
	}
	
	public List<Order> querySendList(String owner,String seller,String begin,String end,int pageIndex,int pageSize) {
		return orderDao.querySendList(owner,seller,begin,end,pageIndex,pageSize);
	}
	
	public List<Order> queryToDoList(String owner,String seller,String begin,String end,int pageIndex,int pageSize) {
		return orderDao.queryToDoList(owner,seller,begin,end,pageIndex,pageSize);
	}
	
	public Integer queryCountByStatus(String owner,String seller,int orderStatus,String begin,String end) {
		return orderDao.queryCountByStatus(owner,seller,orderStatus,begin,end);
	}
	
	public Integer queryProductCount(String owner,String seller,int orderStatus) {
		return orderDao.queryProductCount(owner, seller, orderStatus);
	}
	
	public List<Expressage> queryExpressage() {
		return expressageDao.query();
	}
	
}
