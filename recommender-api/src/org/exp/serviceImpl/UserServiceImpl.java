package org.exp.serviceImpl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.exp.dao.UserDao;
import org.exp.entity.UserProfile;
import org.exp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * recommender.org.exp.serviceImpl
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	public UserDao userDao;

	@Override
	public int signup(String email, String password) {
		UserProfile uProfile = new UserProfile();
		uProfile.setEmail(email);
		uProfile.setPassword(password);
		return userDao.saveNewUser(uProfile);
	}

	@Override
	public UserProfile login(String email, String password) {
		UserProfile userProfile;
		userProfile = userDao.validateUser(email, password);
		userProfile.setPassword("null");
		if (userProfile != null) {
			logger.info("User already exist : " + userProfile.getUserId());
		}
		return userProfile;
	}

}
