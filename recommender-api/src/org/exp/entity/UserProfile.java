package org.exp.entity;

import java.io.Serializable;

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
@Table(name = "userprofile")
public class UserProfile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6448998402444858687L;
	
	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	@Column(name = "id", unique = true, nullable = false)
	private long userId;
	
	@Column(name = "email",unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
