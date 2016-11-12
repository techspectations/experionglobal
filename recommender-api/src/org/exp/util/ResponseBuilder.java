package org.exp.util;

import java.io.Serializable;

/**
 * recommender.org.exp.util
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
public class ResponseBuilder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8973807745284277649L;
	private String message;
	private Object data;

	/**
	 * @return the message
	 */
	public String getMessgae() {
		return message;
	}

	/**
	 * @param messgae
	 *            the message to set
	 */
	public void setMessgae(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
