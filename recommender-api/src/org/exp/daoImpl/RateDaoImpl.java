package org.exp.daoImpl;

import org.apache.log4j.Logger;
import org.exp.dao.RateDao;
import org.exp.entity.Ratting;
import org.exp.entity.UserProfile;
import org.exp.util.ResponseMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * org.exp.daoImpl
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
@Repository("RateDao")
public class RateDaoImpl implements RateDao {

	private Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int updateRate(Long userId, Long newsId, Long userRate) {

		int messageCode = ResponseMessage.RATE_INSERTION_FAILED;
		Session session = sessionFactory.openSession();
		Ratting ratting = new Ratting();

		try {
			ratting.setUserProfile((UserProfile) session.load(UserProfile.class, userId));
			ratting.setNews_id(newsId);
			ratting.setRatting(userRate);
			session.saveOrUpdate(ratting);
			session.flush();
			messageCode = ResponseMessage.RATE_INSERTION_SUCCESSFULL;
		} catch (Exception e) {
			logger.error("Rate updation failed, More Info " + e);
			//e.printStackTrace();
		}
		session.close();

		return messageCode;
	}
}
