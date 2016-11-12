package org.exp.service;

import java.util.List;

import org.exp.dto.ManoramaDto;

/**
 * recommender.org.exp.servicegetRecommendedNews
 * 
 * @author Moamed Sahad KP, Nov 12, 2016
 */
public interface NewsService {

	// Recommended news for particular user
	public List<ManoramaDto> getRecommendedNews(Integer user_id);

}
