package org.exp.recommender;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class UserBaseRecommender {

	public final static String MYSQL_USERNAME = "root";

	public final static String MYSQL_PASSWORD = "exp@root";

	public final static String MYSQL_HOST = "localhost";

	public final static String MYSQL_DATABASE = "news_recommender_demo";

	public List<Long> findRecommendation(Integer user_id) throws IOException, TasteException, SQLException {
		List<Long> list = new ArrayList<Long>();

		try {
			JDBCDataModel model = getMySQLConnection();

			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.5, similarity, model);
			UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

			// UserSimilarity similarity = new LogLikelihoodSimilarity(model);
			// System.out.println("Similarity" + similarity);
			//
			// UserNeighborhood neighborhood = new NearestNUserNeighborhood(10,
			// similarity, model);
			// Recommender recommender = new GenericUserBasedRecommender(model,
			// neighborhood, similarity);

			List<RecommendedItem> recommendations = recommender.recommend(user_id, 10);

			for (RecommendedItem recommendation : recommendations) {
				list.add(recommendation.getItemID());
			}
		} catch (TasteException ex) {
			System.out.println("Error : \n " + ex.toString());
		}
		return list;
	}

	public static JDBCDataModel getMySQLConnection() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName(MYSQL_HOST);
		dataSource.setUser(MYSQL_USERNAME);
		dataSource.setPassword(MYSQL_PASSWORD);
		dataSource.setDatabaseName(MYSQL_DATABASE);
		JDBCDataModel model = new MySQLJDBCDataModel(dataSource, "ratting", "user_id", "news_id", "ratting", null);
		return model;
	}
}
