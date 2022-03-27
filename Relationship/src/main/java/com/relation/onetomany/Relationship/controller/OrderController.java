package com.relation.onetomany.Relationship.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relation.onetomany.Relationship.dto.OrderRequest;
import com.relation.onetomany.Relationship.dto.OrderResponse;
//import com.relation.onetomany.Relationship.dto.ServiceModule;
import com.relation.onetomany.Relationship.entity.Category;
import com.relation.onetomany.Relationship.entity.Product;
import com.relation.onetomany.Relationship.repository.CategoryRepository;
import com.relation.onetomany.Relationship.repository.ProductRepository;

@RestController
public class OrderController {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	//
	
	
	
	@PostMapping("/order")
	public Category placeOrder(@RequestBody OrderRequest request) {
		return categoryRepository.save(request.getCategory());
	}
	
	
	//Get update all value
	@PutMapping("/update")
	public Category update(@RequestBody OrderRequest request) {
		//int id=categoryRepository.save(request.getCategory());
		return categoryRepository.save(request.getCategory());
	}
	//Get all value from Category
	@GetMapping("/search-All-orders")
	public List<Category> findAllOrders(){
		return categoryRepository.findAll();
	}
	
	//Get info all customer
	@GetMapping("/get-Info")
	public List<OrderResponse> getJoinInfo(){
		return categoryRepository.getJoinInformation();
	}
	//Search Category by Id
	@GetMapping("/{id}")
	public Optional<Category> findById(@PathVariable int id){
		return categoryRepository.findById(id);
	}
	
	//Search product by Id
	@GetMapping("/pid{pid}")
	public Optional<Product> findById_1(@PathVariable int pid){
		return productRepository.findById(pid);
	}
	
	//product deleted
	@DeleteMapping("/prod-del{pid}")
	public String delete(@PathVariable int pid){
		productRepository.deleteById(pid);
		return "Deleted  Product successfuly...";
	}
	//customer deleted
	@DeleteMapping("/cat-del{id}")
	public String delete_category(@PathVariable int id){
		categoryRepository.deleteById(id);
		return "Deleted category successfuly...";
		}
		
	//Pagination
	
	@GetMapping("/cat-pag{offset}/{pagesize}")
	public Page<Category> PagionationMethod(@PathVariable int offset,@PathVariable int pagesize){
		return categoryRepository.findAll(PageRequest.of(offset,pagesize));
		
	}
	@GetMapping("/prod-pag{offset}/{pagesize}")
	public Page<Product> PagionationMethod_product(@PathVariable int offset,@PathVariable int pagesize){
		return productRepository.findAll(PageRequest.of(offset,pagesize));
		
	}
	
	
	
	
	
	
	
		
}
