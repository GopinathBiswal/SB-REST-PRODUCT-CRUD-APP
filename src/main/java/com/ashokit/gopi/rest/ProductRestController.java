package com.ashokit.gopi.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.gopi.bindings.Product;
import com.ashokit.gopi.repositories.ProductRepository;

@RestController
@RequestMapping("/prc")
public class ProductRestController {

	@Autowired
	private ProductRepository productRepo;
	
	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productRepo.save(product);
		String msg = "Product Saved successfully...!!";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping(value= "/product/{pid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> getProductById(@PathVariable("pid") Integer productId) {
		Product product=null;
		Optional<Product> findById = productRepo.findById(productId);
		if (findById.isPresent()) {
			product = findById.get();
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productsList = productRepo.findAll();
		return new ResponseEntity<List<Product>>(productsList, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateProduct(Product product) {
		productRepo.save(product);
		String msg = "Product Updated Successfully...!!";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") Integer productId) {
		productRepo.deleteById(productId);
		String msg = "Product Deleted Successfully...!!";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
