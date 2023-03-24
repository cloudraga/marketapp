package com.spboot.market.utils;

public class MarketConstants {

	public final static String BASE_URI = "/api/v1";
		
	public static final String SERVER_RESOURCE_ID = "market-backend-api";

	public static final String OAUTH_CLIENT_ID = "marketapp";
	public static final String OAUTH_CLIENT_SECRET = "Password@1234";
	public static final String OAUTH_AUTH_TYPE = "password"; // authenticating user by password
	public static final String OAUTH_GRANT_TYPE = "client_credentials"; // allowing user as per there grant type
	public static final String OAUTH_REFRESH_TOKEN = "refresh_token"; // allowing user as per there grant type by using
																		// refreshToken
	public static final String SCOPE_READ = "read";
	public static final String SCOPE_WRITE = "write";

	public static final String OAUTH_TOKEN_URL = "/oauth/token";

	public static final String ACCESS_TOKEN_URL = "/oauth/token?grant_type=client_credentials";
	public static final String HTTP = "http://";
	

	public final static String LOGIN_ROOT_ENDPOINT = "/login";

}
