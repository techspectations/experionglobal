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
@Table(name = "news")
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7463633432789856951L;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	@Column(name = "news_id", unique = true, nullable = false)
	private long Id;

	@Column(name = "heading")
	private String heading;

	@Column(name = "content")
	private String content;

	@Column(name = "category")
	private String category;

	@Column(name = "date")
	private Date date;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
