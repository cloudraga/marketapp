package com.spboot.market.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spboot.market.dto.MarketResponseDTO;

@ControllerAdvice
public class MarketException {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MarketResponseDTO> handleProductException(ProductException exception) {
		MarketResponseDTO marketResponseDTO = new MarketResponseDTO();
		marketResponseDTO.setTimestamp(new Date());
		marketResponseDTO.setData(null);
		// marketResponseDTO.setPath(path);//how to get api path
		Map<String, String> errorMsg = new HashMap<String, String>();
		errorMsg.put("errorReason", exception.getErrorMsg());
		marketResponseDTO.setError(errorMsg);
		marketResponseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.ok().body(marketResponseDTO);
	}

}
