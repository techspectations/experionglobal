package org.exp.daoImpl;

/**
 * org.exp.daoImpl
 * 
 * @author Moamed Sahad KP, Nov 12, 2016
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.exp.dao.ManoramaNewsDao;
import org.exp.dto.ManoramaDto;
import org.exp.entity.ManoramaNews;
import org.exp.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository("ManoramaNewsDao")
public class ManoramaNewsDaoImpl implements ManoramaNewsDao {

	private Logger logger = Logger.getLogger(UserDaoImpl.class);

	public static final String MANORAMA_API_URL = "https://developer.manoramaonline.com/api/editions/en/articles/";

	public static final String MANORAMA_API_TOKEN = "eca7290f-248f-53e1-aee1-c8b651533e54";

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long addManoramaNews(ManoramaNews manoramaNews) {

		Long  newsID = null;
		Session session = sessionFactory.openSession();
		ManoramaNews marnNews;
		try {
			marnNews = (ManoramaNews) getManoramaNewsById(manoramaNews.getManoramaID());
			
			if (Util.equalsWithNull(marnNews, null)) {
				session.saveOrUpdate(manoramaNews);
				newsID = manoramaNews.getId();
			}else{
				newsID = marnNews.getId();
			}

			session.flush();
		} catch (Exception e) {
			logger.error("News insertion failed - " + e);
			//e.printStackTrace();
		} finally {
			session.close();
		}

		return newsID;
	}

	public ManoramaNews getManoramaNewsById(String newsId) {
		Session session = sessionFactory.openSession();
		ManoramaNews mNews = null;
		try {
			Query query = session.createQuery("from ManoramaNews nw where nw.manoramaID=:newsID");
			query.setString("newsID", newsId);

			mNews = (ManoramaNews) query.uniqueResult();
			session.flush();
			session.close();
		} catch (Exception e) {
			logger.error("Failed to fetch news by id, More Info" + e);
			// e.printStackTrace();
		}
		return mNews;
	}

	@Override
	public String getManoramaNewsID(Long newsId) {
		Session session = sessionFactory.openSession();
		ManoramaNews news = new ManoramaNews();

		try {
			Query query = session.createQuery("from ManoramaNews mn where mn.Id=:newsID");
			query.setLong("newsID", newsId);

			news = (ManoramaNews) query.uniqueResult();
			session.flush();
		} catch (Exception e) {
			logger.error("Failed to fetch news, More Info" + e);
			// e.printStackTrace();
		}
		session.close();

		return news.getManoramaID();
	}

	@Override
	public ManoramaDto getRecommedNews(String articleID) {
		ManoramaDto manoramaDto = new ManoramaDto();
		try {
			URL url = new URL(MANORAMA_API_URL + articleID);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", MANORAMA_API_TOKEN);

			StringBuilder builder = new StringBuilder();
			InputStream content = connection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			manoramaDto = objectMapper.readValue(builder.toString(), ManoramaDto.class);
		} catch (Exception e) {
			logger.error("Failed to get manorama news, More Info" + e.getMessage());
			// e.printStackTrace();
		}
		return manoramaDto;
	}
}
