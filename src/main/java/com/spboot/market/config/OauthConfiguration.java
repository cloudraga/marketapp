package com.spboot.market.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.spboot.market.encryption.EncryptionUtilityService;
import com.spboot.market.utils.MarketConstants;


@Configuration
@EnableAuthorizationServer
public class OauthConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private EncryptionUtilityService encryptionUtilityService;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(MarketConstants.OAUTH_CLIENT_ID)
				.secret(encryptionUtilityService.passwordEncoder().encode(MarketConstants.OAUTH_CLIENT_SECRET)) //hashed password
				.authorizedGrantTypes(MarketConstants.OAUTH_AUTH_TYPE, MarketConstants.OAUTH_GRANT_TYPE,
						MarketConstants.OAUTH_REFRESH_TOKEN)
				.scopes(MarketConstants.SCOPE_READ, MarketConstants.SCOPE_WRITE).accessTokenValiditySeconds(1)
				.autoApprove(true);
	}

	@Bean
	public TokenStore tokenStore() {
		JwtAccessTokenConverter jwtTokenEnhancer = defaultAccessTokenConverter();
		JwtTokenStore store = new JwtTokenStore(jwtTokenEnhancer);
		return store;
	}

	@Bean
	public JwtAccessTokenConverter defaultAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("signingKey");
		return converter;
	}

}
