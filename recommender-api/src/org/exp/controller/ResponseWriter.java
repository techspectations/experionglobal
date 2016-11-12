package org.exp.controller;

import org.exp.util.ResponseBuilder;
import org.exp.util.ResponseMessage;

/**
 * recommender.org.exp.controller
 * 
 * @author Mohamed Sahad KP, Nov 12, 2016
 */
public abstract class ResponseWriter {
	
	protected int messageCode;
	
	abstract public ResponseBuilder response(int messageCode,Object data);
	

	public Object apiResponse(int messageCode, Object object) {
		ResponseMessage reMessage = new ResponseMessage();
		ResponseBuilder responseBuilder = new ResponseBuilder();
		responseBuilder.setMessgae(reMessage.getMessage(messageCode));
		responseBuilder.setData(object);
		return responseBuilder;
	}
}
