package org.exp.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.exp.dao.ManoramaNewsDao;
import org.exp.dto.ManoramaDto;
import org.exp.recommender.UserBaseRecommender;
import org.exp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * recommender.org.exp.serviceImpl
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

	private Logger logger = Logger.getLogger(NewsServiceImpl.class);

	@Autowired
	public ManoramaNewsDao manoramaNewsDao;

	@Override
	public List<ManoramaDto> getRecommendedNews(Integer user_id) {
		UserBaseRecommender baseRecommender = new UserBaseRecommender();
		List<ManoramaDto> newsList = new ArrayList<ManoramaDto>();

		try {
			List<Long> list = baseRecommender.findRecommendation(user_id);
			if (list != null) {
				Iterator<Long> listIterator = list.iterator();
				while (listIterator.hasNext()) {
					newsList.add(
							manoramaNewsDao.getRecommedNews(manoramaNewsDao.getManoramaNewsID(listIterator.next())));
				}
			}
		} catch (Exception e) {
			logger.error("News recommedation is failed, More Info" + e.getMessage());
			e.printStackTrace();
		}
		return newsList;
	}
}
