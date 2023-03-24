package com.spboot.market.encryption;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface EncryptionUtilityService {

	public PasswordEncoder passwordEncoder();

}
