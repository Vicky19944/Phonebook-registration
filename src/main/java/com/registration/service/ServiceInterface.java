package com.registration.service;


import java.util.Map;

import org.springframework.stereotype.Component;


import com.registration.entity.UnlockAcc;
import com.registration.entity.User;

@Component
public interface ServiceInterface {

	public String cheackSignIn(String email, String password);

	public Map<Integer, String> getCountry( );

	public Map<Integer, String> getState(Integer countryId);

	public Map<Integer, String> getCity(Integer stateId);

	public User getUserByEmail(String email);

	public boolean saveUser(User u);
	
	public String unLockAcc(UnlockAcc acc);

	public User  forgotPassword(String emailId);

	

}
