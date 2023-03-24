package com.spboot.market.serviceimpl;

import java.net.URISyntaxException;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spboot.market.dao.LoginDao;
import com.spboot.market.dto.LoginDTO;
import com.spboot.market.entity.Login;
import com.spboot.market.service.LoginService;
import com.spboot.market.utils.MarketUtils;
import com.spboot.market.utils.TokenResponse;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Override
	public LoginDTO login(LoginDTO loginDTO) {
		LoginDTO respLoginDTO = null;
		try {
			Login dblogin = loginDao.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
			if (dblogin != null) {

				TokenResponse response = MarketUtils.getAccessToken(httpServletRequest);
				if (response != null) {
					System.out.println("access token is : " + response.getAccess_token());
				}

				respLoginDTO = new LoginDTO();
				respLoginDTO.setUsername(dblogin.getUsername());
				respLoginDTO.setPassword(dblogin.getPassword());
			}
		} catch (UnknownHostException | URISyntaxException e) {
			e.printStackTrace();
		}
		return respLoginDTO;
	}

}
