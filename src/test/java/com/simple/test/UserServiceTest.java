package com.simple.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.simple.dao.OrderDao;
import com.simple.model.SellerListVO;
import com.simple.model.SellerMainVO;
import com.simple.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

	@Resource
	OrderDao orderDao;
	
//	@Test
	public void toSellerMainHead(){
		User user = new User();
		user.setUserPhone("18712301230");
		user.setBalance(3000.0);
		SellerMainVO vo = orderDao.getTotalSellerAmount(user);
		vo.setBalance(user.getBalance());
		vo.setWithdrawAmount(user.getBalance());
		System.out.println(JSON.toJSONString(vo));
	}
	
	@Test
	public void toSellerMainList(){
		User user = new User();
		user.setUserPhone("18712301230");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageIndex", 0);
		params.put("pageSize", 5);
		params.put("userPhone", user.getUserPhone());
		List<SellerListVO> vo = orderDao.getSellerList(params);
		System.out.println(JSON.toJSONString(vo));
	}
	
	
}
