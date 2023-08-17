package coms.RestApiCurdOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coms.RestApiCurdOperations.model.Product;
import coms.RestApiCurdOperations.service.ProductService;

@RestController
@RequestMapping("v1/api")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> ViewAll(){
		List<Product> pall = ps.showAll();
		if(pall.isEmpty())
			return new ResponseEntity("List is empty", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Product>>(pall, HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<String> SaveProduct(@RequestBody Product prod){
		String res = ps.AddNewProduct(prod);
		if(res.equals("Success"))
			return new ResponseEntity("Product added...", HttpStatus.OK);
		return new ResponseEntity<String>("Product not added...", HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> ViewOneProduct(@PathVariable Integer id){
		Product prd = ps.GetAProduct(id);
		if(prd!=null)
			return new ResponseEntity<Product>(prd,HttpStatus.OK);
		return new ResponseEntity("Product not found...",HttpStatus.NOT_FOUND);	
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> DeleteProduct(@PathVariable Integer id){
		String str = ps.DeleteProduct(id);
		if(id!=null)
			return new ResponseEntity<String>("Product deleted...",HttpStatus.OK);
		return new ResponseEntity<String>("Product not found...",HttpStatus.NOT_FOUND);
	} 
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> UpdateProduct(@RequestBody Product prd, @PathVariable Integer id){
		if(ps.GetAProduct(id)!=null) {
			String res = ps.UpdateProduct(prd);
			if(res.equals("Success"))
				return new ResponseEntity<String>("Product updated...",HttpStatus.OK);
			return new ResponseEntity<String>("Product not updated...",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Product not found...",HttpStatus.NOT_FOUND);
	}
}








