package org.exp.dao;

/**
 * org.exp.dao
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */

public interface RateDao {

	//Update user interest on news
	public int updateRate(Long user_id, Long item_id, Long user_rate);

}
