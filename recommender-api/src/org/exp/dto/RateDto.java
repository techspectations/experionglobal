package org.exp.dto;

import java.io.Serializable;

public class RateDto implements Serializable {

	private static final long serialVersionUID = -3788499964003532745L;

	private Long rate_id;

	private Long user_id;

	private String news_id;

	private Long user_rate;

	public Long getRate_id() {
		return rate_id;
	}

	public void setRate_id(Long rate_id) {
		this.rate_id = rate_id;
	}

	public Long getUser_rate() {
		return user_rate;
	}

	public void setUser_rate(Long user_rate) {
		this.user_rate = user_rate;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getNews_id() {
		return news_id;
	}

	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}

}
