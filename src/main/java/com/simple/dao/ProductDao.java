package com.simple.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.common.mybatis.annotation.DatabaseTemplate;
import com.simple.common.mybatis.dao.BaseIbatisDao;
import com.simple.model.Product;
import com.simple.model.ProductImage;

@Repository
@DatabaseTemplate("st_all")
public class ProductDao extends BaseIbatisDao{
	
	public Product getById(int id) {
		return this.sqlSession.selectOne("product.queryById",id);
	}

	public ProductImage getImage(int productId) {
		return this.sqlSession.selectOne("product.queryImage",productId);
	}
	
	public List<Product> getByOwners(List<String> owners,String name,int productStatus,int pageIndex,int pageSize) {
		if (pageIndex < 1) {
			pageIndex  =1;
		}
		Map<String,Object> param = new HashMap<String,Object>(); 
		param.put("name", name);
		param.put("ids", owners);
		param.put("startnum", (pageIndex-1)*pageSize);
		param.put("pageSize", pageSize);
		param.put("productStatus", productStatus);
		return this.sqlSession.selectList("product.queryByOwner",param);
	}
	
	public int getCountByOwners(List<String> owners,String name,int productStatus) {
		Map<String,Object> param = new HashMap<String,Object>(); 
		param.put("name", name);
		param.put("ids", owners);
		param.put("productStatus", productStatus);
		return this.sqlSession.selectOne("product.queryCountByOwner",param);
	}
	
	public int addProduct(Product product) {
		return this.sqlSession.insert("product.insert",product);
	}
	
	public int updateProduct(Product product) {
		return this.sqlSession.update("product.update",product);
	}
	
	public int reduceStock(int id) {
		return this.sqlSession.update("product.reduceStock",id);
	}
	
	public void addProductImage(ProductImage image) {
		this.sqlSession.insert("product.insertImage",image);
	}
	
	public void deleteProductImage(int productId) {
		this.sqlSession.delete("product.deleteImage");
	}
	
	public void updateStatus(int id,int status) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("productStatus", status);
		this.sqlSession.update("product.updatestatus",param);
	}
	
	public int queryNoStockCount(String owner) {
		return this.sqlSession.selectOne("product.queryNoStock",owner);
	}

}
