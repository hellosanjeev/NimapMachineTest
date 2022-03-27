package com.relation.onetomany.Relationship.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@SelectBeforeUpdate
public class Category {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(int id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cp_fk",referencedColumnName="id")
	private List<Product> products;



	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
	



	

}
