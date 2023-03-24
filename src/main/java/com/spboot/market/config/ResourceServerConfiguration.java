package com.spboot.market.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.spboot.market.utils.MarketConstants;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(MarketConstants.SERVER_RESOURCE_ID);
	}

	// white listing IP's / URL's
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(MarketConstants.BASE_URI + MarketConstants.LOGIN_ROOT_ENDPOINT).permitAll() // api/v1/login	
		                        //.antMatchers(MarketConstants.BASE_URI + MarketConstants.TEAM_GET_REQUEST+ "/**/**").permitAll() //api/v1/teams/
		                       // .antMatchers(MarketConstants.BASE_URI + MarketConstants.SIGNUP_GET_REQUEST).permitAll() //api/v1/signup
		                        //.antMatchers(CricketConstants.BASE_URI + CricketConstants.PLAYER_GET_REQUEST+ "/**/**").permitAll() //api/v1/teams/
								.antMatchers("/api/v1/**").authenticated();
	}

}
