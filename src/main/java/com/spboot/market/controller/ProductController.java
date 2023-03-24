package com.spboot.market.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spboot.market.dto.MarketResponseDTO;
import com.spboot.market.dto.ProductDTO;
import com.spboot.market.service.ProductService;
import com.spboot.market.utils.MarketConstants;

@RestController
@RequestMapping(value = MarketConstants.BASE_URI)
public class ProductController {

	@Autowired
	private ProductService productService;

	// Initial Code
	// @PostMapping("/products")
	// public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
	// return productService.createProduct(productDTO);
	// }
	//
	// @GetMapping("/products")
	// public List<ProductDTO> getAllProducts() {
	// return productService.getAllProducts();
	// }
	//
	// @GetMapping("/products/{pid}")
	// public ProductDTO getProduct(@PathVariable int pid) {
	// return productService.getProduct(pid);
	// }

	@GetMapping("/products/{pid}")
	public ResponseEntity<MarketResponseDTO> getProduct(@PathVariable int pid) {
		MarketResponseDTO marketResponseDTO = new MarketResponseDTO();
		marketResponseDTO.setTimestamp(new Date());
		ProductDTO productDTO = productService.getProduct(pid);
		marketResponseDTO.setData(productDTO);
		// marketResponseDTO.setPath(path);//how to get api path //HttpServletRequest
		marketResponseDTO.setError(null);
		marketResponseDTO.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok().body(marketResponseDTO);
	}

	@GetMapping("/products")
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping("/products")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}
}
