package com.simple.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.simple.model.SellerJoinVO;
import com.simple.service.AgentSellerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*.xml")
public class AgentSellerServiceTest {

	@Autowired
	AgentSellerService service;
	
	@Test
	public void getSellerJoinList(){
		PageInfo<SellerJoinVO> page = service.getSellerJoinList("18712301230", 1, 5);
		String result = JSON.toJSONString(page.getList());
		System.out.println(result);
	}
	
}
