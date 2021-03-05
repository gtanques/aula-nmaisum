package com.example.demo.service;

import java.util.stream.Collectors;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public Page<ProductDTO> find(PageRequest pageRequest) {
		Page<Product> page = repository.findAll(pageRequest);
		repository.findProductsAndCategories(page.stream().collect(Collectors.toList()));
		return page.map(x -> new ProductDTO(x));
	}
}
