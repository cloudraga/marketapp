package com.spboot.market.service;

import java.util.List;

import com.spboot.market.dto.ProductDTO;

public interface ProductService {

	public ProductDTO createProduct(ProductDTO productDTO);

	public List<ProductDTO> getAllProducts();

	public ProductDTO getProduct(int id);

}
