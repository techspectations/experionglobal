package org.exp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * recommender.org.exp.entity
 * 
 * @author Vishnu Nov 12, 2016
 */
@Entity
@Table(name = "manorama_news")
public class ManoramaNews implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7463633432789856951L;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	@Column(name = "news_id", unique = true, nullable = false)
	private Long Id;
	
	@Column(name = "manoramaID")
	private String manoramaID;

	public String getManoramaID() {
		return manoramaID;
	}

	public void setManoramaID(String manoramaID) {
		this.manoramaID = manoramaID;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}
