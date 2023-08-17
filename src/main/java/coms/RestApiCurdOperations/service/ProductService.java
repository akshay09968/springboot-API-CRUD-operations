package coms.RestApiCurdOperations.service;

import java.util.List;

import coms.RestApiCurdOperations.model.Product;

public interface ProductService {
	public String AddNewProduct(Product prod);
	public List<Product> showAll();
	public Product GetAProduct(int prdid);
	public String UpdateProduct(Product prod);
	public String DeleteProduct(int prdid);
}
