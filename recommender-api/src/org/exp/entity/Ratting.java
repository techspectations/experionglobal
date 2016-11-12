package org.exp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * recommender.org.exp.entity
 * 
 * @author Vishnu Nov 12, 2016
 */
@Entity
@Table(name = "ratting")
public class Ratting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1906647549790197162L;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserProfile userProfile;

	@Column(name = "news_id")
	private Long news_id;

	@Column(name = "ratting")
	private Long ratting;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Long getRatting() {
		return ratting;
	}

	public void setRatting(Long ratting) {
		this.ratting = ratting;
	}
	
	public Long getNews_id() {
		return news_id;
	}

	public void setNews_id(Long news_id) {
		this.news_id = news_id;
	}

}
