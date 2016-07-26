package com.simple.test;

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.simple.model.SellerListVO;
import com.simple.model.SellerMainVO;
import com.simple.model.User;
import com.simple.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

	@Resource
	UserService service;
	
//	@Test
	public void toSellerMainHead(){
		User user = new User();
		user.setUserPhone("18712301230");
		user.setBalance(3000.0);
//		SellerMainVO vo = service.toSellerMainHead(user);
//		vo.setBalance(user.getBalance());
//		vo.setWithdrawAmount(user.getBalance());
//		System.out.println(JSON.toJSONString(vo));
	}
	
	@Test
	public void toSellerMainList(){
		User user = new User();
		user.setUserPhone("18712301230");
//		PageInfo<SellerListVO> page = service.toSellerMainList(user.getUserPhone(), 1, 1);
//		System.out.println(page.getTotal());
//		System.out.println(JSON.toJSONString(page.getList()));
	}
	
	
}
