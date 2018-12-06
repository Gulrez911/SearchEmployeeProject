package com.kgate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgate.dao.LoginDao2;
import com.kgate.model.User;

@Service
public class LoginService2Impl  implements LoginService2{
	
	@Autowired
	private LoginDao2 ld;
			
			 public void setLoginDAO(LoginDao2  ld) 
			 {
				this.ld=ld;
			 }
			 
			@Override
			public boolean checkLogin(User u) {
				// TODO Auto-generated method stub
				return ld.checkLogin(u);
			}
	}

			


