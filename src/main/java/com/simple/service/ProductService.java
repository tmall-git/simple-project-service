package com.simple.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.dao.ProductDao;
import com.simple.model.PageResult;
import com.simple.model.Product;
import com.simple.model.ProductImage;
@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product getById(int id){
		return productDao.getById(id);
	}
	
	public PageResult query(String name,List<String> owners,int productStatus ,int pageIndex,int pageSize){
		List<Product> products = productDao.getByOwners(owners, name,productStatus, pageIndex, pageSize);
		int total = productDao.getCountByOwners(owners, name, productStatus);
		PageResult p = new PageResult(total, pageSize, pageIndex, products);
		return p;
	}

	public void insert(Product product,String[] images) {
		if (null != images && images.length > 0) {
			product.setThumbnail(images[0]);
		}
		int id = productDao.addProduct(product);
		if (null != images && images.length > 0) {
			for (int i = 0 ; i < images.length;i++) {
				String ima = images[i];
				ProductImage pi = new ProductImage();
				pi.setImage(ima);
				pi.setProductId(id);
				productDao.addProductImage(pi);
			}
		}
	}
	
	public void update(Product product,String[] images){
		if (null != images && images.length > 0) {
			product.setThumbnail(images[0]);
		}
		productDao.updateProduct(product);
		productDao.deleteProductImage(product.getId());
		if (null != images && images.length > 0 ) {
			for (int i = 0 ; i < images.length;i++) {
				String ima = images[i];
				ProductImage pi = new ProductImage();
				pi.setImage(ima);
				pi.setProductId(product.getId());
				productDao.addProductImage(pi);
			}
		}
	}
	
	public int updateStock(int productId) {
		return productDao.reduceStock(productId);
	}
	
	public void updateProductStatus(int id,int status ) {
		productDao.updateStatus(id, status);
	}
	
	public int queryProductCount(int productStatus,String owner) {
		List<String> owners = new ArrayList<String>();
		owners.add(owner);
		return productDao.getCountByOwners(owners, null, productStatus);
	}
	
	public int queryNoStockCount(String owner) {
		return productDao.queryNoStockCount(owner);
	}
}
