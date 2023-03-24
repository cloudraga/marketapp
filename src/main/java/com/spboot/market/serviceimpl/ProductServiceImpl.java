package com.spboot.market.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spboot.market.dao.ProductDao;
import com.spboot.market.dto.ProductDTO;
import com.spboot.market.entity.Product;
import com.spboot.market.exception.ProductException;
import com.spboot.market.mapper.ProductMapper;
import com.spboot.market.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = ProductMapper.createProductEnitity(productDTO);
		Product dbProduct = productDao.save(product);
		ProductDTO respDto = ProductMapper.createDTOObject(dbProduct);
		return respDto;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productDao.findAll();
		List<ProductDTO> respProductDTOs = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = ProductMapper.createDTOObject(product);
			respProductDTOs.add(productDTO);
		}
		return respProductDTOs;
	}

	@Override
	public ProductDTO getProduct(int id) {
		Optional<Product> opProduct = productDao.findById(id);
		ProductDTO productDTO = null;
		if (opProduct.isPresent()) {
			Product product = opProduct.get();
			productDTO = ProductMapper.createDTOObject(product);
		}else {
			throw new ProductException("Invalid Product Id.");
		}
		return productDTO;
	}

}