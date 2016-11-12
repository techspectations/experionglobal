package org.exp.serviceImpl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.exp.dao.ManoramaNewsDao;
import org.exp.dao.RateDao;
import org.exp.dto.RateDto;
import org.exp.entity.ManoramaNews;
import org.exp.service.RateService;
import org.exp.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * recommender.org.exp.serviceImpl
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
@Service
@Transactional
public class RateServiceImpl implements RateService {

	private Logger logger = Logger.getLogger(RateServiceImpl.class);

	private int messageCode = ResponseMessage.OPERATION_FAILED;

	@Autowired
	public RateDao newsDao;

	@Autowired
	public ManoramaNewsDao manoramaNewsDao;

	@Override
	public int updateRate(String userRateRequest) {
		RateDto rateDto = new RateDto();
		ManoramaNews manoramaNews = new ManoramaNews();
		Long manoramaNewsID = null;

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			rateDto = objectMapper.readValue(userRateRequest.toString(), RateDto.class);

			manoramaNews.setManoramaID(rateDto.getNews_id());
			manoramaNewsID = manoramaNewsDao.addManoramaNews(manoramaNews);

			if (manoramaNewsID != null) {
				messageCode = newsDao.updateRate(rateDto.getUser_id(), manoramaNewsID, rateDto.getUser_rate());
			} else {
				// System.out.println("No manorama news found");
				logger.error("No manorama news found");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("User interest updation failed, More Info" + e);
		}
		return messageCode;
	}

}
