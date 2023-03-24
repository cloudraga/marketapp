package com.spboot.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spboot.market.entity.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer> {

	// select * from login where username=? and password=?;
	public Login findByUsernameAndPassword(String uname, String pwd);
	
}
