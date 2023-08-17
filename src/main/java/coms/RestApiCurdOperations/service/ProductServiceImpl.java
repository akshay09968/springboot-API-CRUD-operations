package coms.RestApiCurdOperations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.RestApiCurdOperations.model.Product;
import coms.RestApiCurdOperations.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo prepo;
	
	@Override
	public String AddNewProduct(Product prod) {
		Product p = prepo.save(prod);
		if(p!=null)
			return "Success";
		return null;
	}

	@Override
	public List<Product> showAll() {
		return prepo.findAll();
	}

	@Override
	public Product GetAProduct(int prdid) {
		Optional<Product> pinfo = prepo.findById(prdid);
		if(pinfo.isPresent())
			return pinfo.get();
		return null;
	}

	@Override
	public String UpdateProduct(Product prod) {
		Product p = prepo.saveAndFlush(prod);
		if(p!=null) 
			return "Success";
		return "Error";
	}

	@Override
	public String DeleteProduct(int prdid) {
		Optional<Product> pinfo = prepo.findById(prdid);
		if(pinfo.isPresent()) {
			prepo.deleteById(prdid);
			return "Success";
		}
		return "Error";
	}

}










