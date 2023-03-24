package com.spboot.market.utils;

import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class MarketUtils {

	private MarketUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static TokenResponse getAccessToken(HttpServletRequest request)
			throws URISyntaxException, UnknownHostException {

		InetAddress ip;
		ResponseEntity<TokenResponse> response = null;
		RestTemplate restTemplate = new RestTemplate();

		// authenticating the user by passing client ID & Secret
		restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(MarketConstants.OAUTH_CLIENT_ID,
				MarketConstants.OAUTH_CLIENT_SECRET));

		// fetching complete URI where app is running
		ip = InetAddress.getLocalHost();

		// preparing URL for rest request
		String accessTokenUrl = MarketConstants.HTTP + ip.getHostAddress() + ":" + request.getLocalPort()
				+ request.getContextPath() + MarketConstants.ACCESS_TOKEN_URL;

		// setting headers
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> req = new HttpEntity<String>(headers);

		// passing prepared URL to URI
		URI uri = new URI(accessTokenUrl);

		response = restTemplate.exchange(uri, HttpMethod.POST, req, TokenResponse.class);

		return response.getBody();
	}

}