package com.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.dao.ProductDao;
import com.simple.model.Product;
import com.simple.model.ProductImage;
@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product getById(int id){
		return productDao.getById(id);
	}
	
	public List<Product> query(String name,List<String> owners,int pageIndex,int pageSize){
		return productDao.getByOwners(owners, name, pageIndex, pageSize);
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
	
	public int reduceStock(int productId) {
		return productDao.reduceStock(productId);
	}
	
	public void updateProductStatus(int id,int status ) {
		productDao.updateStatus(id, status);
	}
}
