package org.exp.dao;

import org.exp.entity.UserProfile;

/**
 * recommender.org.exp.dao
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
public interface UserDao {
	/**
	 * 
	 * @param uProfile
	 * @return login status
	 */
	public int saveNewUser(UserProfile uProfile);

	/**
	 * 
	 * @param email
	 * @param password
	 * @return user info
	 */
	public UserProfile validateUser(String email, String password);

}
