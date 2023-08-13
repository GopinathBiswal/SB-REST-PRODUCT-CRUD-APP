package com.ashokit.gopi.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.gopi.bindings.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable> {

}
