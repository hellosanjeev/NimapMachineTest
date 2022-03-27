package com.relation.onetomany.Relationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.relation.onetomany.Relationship.dto.OrderResponse;
import com.relation.onetomany.Relationship.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
	@Query("select new com.relation.onetomany.Relationship.dto.OrderResponse( c.name,p.productName) From Category c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();

}
