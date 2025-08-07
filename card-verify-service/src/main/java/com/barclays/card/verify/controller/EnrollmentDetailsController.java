package com.barclays.card.verify.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.card.verify.model.EnrollmentRequest;
import com.barclays.card.verify.model.EnrollmentResponse;
import com.barclays.card.verify.util.OfferDetailsConstant;

@RestController
@RequestMapping("/v1")
public class EnrollmentDetailsController {

	@PostMapping("/enrollment")
	EnrollmentResponse enrollment(@RequestBody EnrollmentRequest EnrollmentRequest,
			@RequestHeader(name = OfferDetailsConstant.CLIENT_ID, required = false) String clientId,
			@RequestHeader(name = OfferDetailsConstant.CHANNEL_ID, required = false) String channelid,
			@RequestHeader(name = OfferDetailsConstant.MSG_TS, required = false) String msgTs,
			@RequestHeader(name = OfferDetailsConstant.CORRELATION_ID, required = false) String correlational,
			@RequestHeader(name = OfferDetailsConstant.AUTH_TOKEN, required = false) String authToken) {

		System.out.println("Entered into EnrollmentDetailsController");

		EnrollmentResponse enrollmentResponse = new EnrollmentResponse();

		enrollmentResponse.setRespCode("0");
		enrollmentResponse.setRespMsg("success");
		enrollmentResponse.setStatus("active");

		System.out.println("Exit from EnrollmentDetailsController");

		return enrollmentResponse;

	}

}
