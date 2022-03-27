package com.relation.onetomany.Relationship.dto;


import com.relation.onetomany.Relationship.entity.Category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class OrderRequest {
	private Category category;
	
	

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(Category category) {
		super();
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "OrderRequest [category=" + category + "]";
	}
	
	
	
}
