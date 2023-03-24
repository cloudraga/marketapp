package com.spboot.market.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spboot.market.dto.LoginDTO;
import com.spboot.market.dto.MarketResponseDTO;
import com.spboot.market.service.LoginService;
import com.spboot.market.utils.MarketConstants;

@RestController
@RequestMapping(value = MarketConstants.BASE_URI)
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<MarketResponseDTO> doLogin(@RequestBody LoginDTO loginDTO) {
		MarketResponseDTO marketResponseDTO = new MarketResponseDTO();
		marketResponseDTO.setTimestamp(new Date());
		LoginDTO respLoginDTO = loginService.login(loginDTO);
		marketResponseDTO.setData(respLoginDTO);
		// marketResponseDTO.setPath(path);//how to get api path //HttpServletRequest
		marketResponseDTO.setError(null);
		marketResponseDTO.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.ok().body(marketResponseDTO);
	}
}
