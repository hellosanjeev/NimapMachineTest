package com.relation.onetomany.Relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.relation.onetomany.Relationship.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
