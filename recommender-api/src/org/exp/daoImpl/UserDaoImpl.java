package org.exp.daoImpl;

/**
 * org.exp.daoImpl
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
import org.apache.log4j.Logger;
import org.exp.dao.UserDao;
import org.exp.entity.UserProfile;
import org.exp.util.ResponseMessage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	private Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveNewUser(UserProfile uProfile) {
		int messageCode = ResponseMessage.SIGNUP_FAILED;
		Session session = sessionFactory.openSession();
		try {
			session.save(uProfile);
			session.flush();
			messageCode = ResponseMessage.SIGNUP_SUCCESS;
		} catch (Exception e) {
			logger.error("Login failed, More Info" + e.getMessage());
			//e.printStackTrace();
		}
		session.close();
		return messageCode;

	}

	@Override
	public UserProfile validateUser(String email, String password) {
		Session session = sessionFactory.openSession();
		UserProfile uProfile = new UserProfile();
		try {
			Criteria cr = session.createCriteria(UserProfile.class);
			cr.add(Restrictions.eq("email", email));
			uProfile = (UserProfile) cr.uniqueResult();
			session.flush();
		} catch (Exception e) {
			logger.error("Signup failed, More Info" + e.getMessage());
			// e.printStackTrace();
		}
		session.close();
		return uProfile;
	}
}
