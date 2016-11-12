package org.exp.util;

import java.util.Arrays;

/**
 * recommender.org.exp.util
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
public class ResponseMessage {

	/*
	 * Class variable to store message code to get status code.
	 */
	private int messageCode = OPERATION_SUCCESS;

	/**
	 * Message code
	 */
	public static final int NO_MESSAGE = -2;
	public static final int OPERATION_FAILED = -1;
	public static final int OPERATION_SUCCESS = 0;
	public static final int SIGNUP_SUCCESS = 1;
	public static final int SIGNUP_FAILED = 2;
	public static final int CONFORM_MAIL_FAILED = 3;
	public static final int DUPLICATE_FIELD_NAME = 4;

	public static final int LOGIN_FAILED = 5;
	public static final int LOGIN_SUCCESSFULL = 6;

	public static final int NEWS_INSERTION_FAILED = 7;
	public static final int NEWS_INSERTION_SUCCESSFULL = 8;

	public static final int RATE_INSERTION_FAILED = 11;
	public static final int RATE_INSERTION_SUCCESSFULL = 12;

	public static final int REC_NEWS_FAILED = 13;
	public static final int RECN_EWS_SUCCESSFULL = 14;

	private static String[] databaseMessages = { "Operation failed please try again.", "Field updated successfully.",
			"sign up completed, please login.", "signup failed, please try after some time",
			"email and conform mail must be same", "user already exist", "login failed", "user loggedin successfully.",
			"News insertion failed", "Successfully posted news", "Failed to load all news",
			"Successfully loaded all news", "Rate Updation failed", "Successfully update news rate",
			"Failed to fecth recommened news", "Successfully loaded recommended news"

	};

	private static Integer[] successMessages = { NO_MESSAGE, OPERATION_SUCCESS, };

	/**
	 * Status code and status message
	 */
	public static enum StatusCode {
		success, error, ok
	};

	/**
	 * This method is used to get message for particular message code
	 * 
	 * @param success
	 * @return
	 */
	public String getMessage(int messageCode) {
		this.messageCode = messageCode; // class variable is set with the msg
		if (messageCode == NO_MESSAGE)
			return "";
		return databaseMessages[messageCode + 1];
	}

	public StatusCode getStatus() {
		return Arrays.asList(successMessages).contains(messageCode) ? StatusCode.success : StatusCode.error;
	}

}
