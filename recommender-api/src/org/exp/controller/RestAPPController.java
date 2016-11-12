package org.exp.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.exp.dto.ManoramaDto;
import org.exp.entity.UserProfile;
import org.exp.service.NewsService;
import org.exp.service.RateService;
import org.exp.service.UserService;
import org.exp.util.ResponseBuilder;
import org.exp.util.ResponseMessage;
import org.exp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/**
 * org.exp.controller
 * 
 * @author Mohamed Sahad KP,  Nov 12, 2016
 */

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*")
public class RestAPPController extends ResponseWriter {

	private Logger logger = Logger.getLogger(RestAPPController.class);

	public static final String API_STATUS = "Success";

	public static final String API_STATUS_MSG = "All API Operational";

	@Autowired
	private UserService userService;

	@Autowired
	private NewsService newsService;

	@Autowired
	private RateService rateService;

	// Check Application Status
	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String verifyToken() {
		List<String> a = new ArrayList<>();
		a.add(API_STATUS);
		a.add(API_STATUS_MSG);
		// System.out.println("API Status:" + API_STATUS);
		return new Gson().toJson(a);

	}

	// SignUp
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBuilder> signup(@RequestHeader("email") String email,
			@RequestHeader("confirm_email") String conformEmail, @RequestHeader("password") String password) {

		messageCode = ResponseMessage.CONFORM_MAIL_FAILED;
		if (email.equals(conformEmail)) {
			messageCode = userService.signup(conformEmail, password);
			return ResponseEntity.ok(response(messageCode, null));
		} else {
			return new ResponseEntity<>(response(messageCode, null), HttpStatus.BAD_REQUEST);
		}
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBuilder> login(@RequestHeader("email") String email,
			@RequestHeader("password") String password) {

		UserProfile uProfile = userService.login(email, password);
		messageCode = Util.equalsWithNull(uProfile, null) ? ResponseMessage.LOGIN_FAILED
				: ResponseMessage.LOGIN_SUCCESSFULL;
		return ResponseEntity.ok(response(messageCode, uProfile));

	}

	// Update user news interest
	@RequestMapping(value = "/update-rate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBuilder> updateNewsRatting(@RequestBody String userRateRequest) {
		messageCode = rateService.updateRate(userRateRequest);
		return ResponseEntity.ok(response(messageCode, null));
	}

	// Recommended news using "user_id"
	@RequestMapping(value = "/recommended-news/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBuilder> getRecommendedNews(@PathVariable("user_id") Integer user_id) {
		try {
			List<ManoramaDto> newsList = newsService.getRecommendedNews(user_id);

			if (newsList == null) {
				messageCode = ResponseMessage.REC_NEWS_FAILED;
				return ResponseEntity.ok(response(messageCode, null));
			} else {
				messageCode = ResponseMessage.RECN_EWS_SUCCESSFULL;
				return ResponseEntity.ok(response(messageCode, newsList));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to fetch recommended news  - " + e);
			return new ResponseEntity<>(response(messageCode, null), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseBuilder response(int messageCode, Object data) {
		ResponseMessage reMessage = new ResponseMessage();
		ResponseBuilder responseBuilder = new ResponseBuilder();
		responseBuilder.setMessgae(reMessage.getMessage(messageCode));
		responseBuilder.setData(data);
		return responseBuilder;

	}
}
