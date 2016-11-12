package org.exp.service;

import org.exp.entity.UserProfile;

/**
 * recommender.org.exp.service
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
public interface UserService {

	//SignUp
	public int signup(String email, String password);

	//Login
	public UserProfile login(String email, String password);

}
