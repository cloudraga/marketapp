package com.spboot.market.mapper;

import com.spboot.market.dto.ProductDTO;
import com.spboot.market.entity.Product;

public class ProductMapper {

	public static ProductDTO createDTOObject(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		return productDTO;
	}

	public static Product createProductEnitity(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());

		return product;
	}

}
