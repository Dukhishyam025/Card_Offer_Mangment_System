package com.barclays.offers.ennrollment.svcclient;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.barclays.offers.model.EnrollmentRequest;
import com.barclays.offers.model.EnrollmentResponse;

@Component
public class EnrollmentServiceClientImpl implements IEnrollmentServiceClient {

	@Value("${enrollment_srv_uri}")
	private String enrollmentSvcUri;

	@Autowired
	RestTemplate restTemplate;

//	@Override
//	public EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest) {
//
//		EnrollmentResponse enrollmentResp = new EnrollmentResponse();
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//
//		headers.add("authToken", "@#$%^&*(*&^%");
//		headers.add("channelid", "");
//		headers.add("clientId", "");
//		headers.add("correlationId", UUID.randomUUID().toString().substring(0, 16));
//		headers.add("msgTs", new Date().toString());
//
//		HttpEntity<EnrollmentRequest> requestEntity = new HttpEntity<EnrollmentRequest>(enrollmentRequest, headers);
//
//		restTemplate = new RestTemplate();
//		
//		ResponseEntity<EnrollmentResponse> responseEntity = restTemplate.exchange(enrollmentSvcUri, HttpMethod.POST,
//				requestEntity, EnrollmentResponse.class);
//
////		if (responseEntity.getStatusCode() == HttpStatus.OK) {
////			enrollmentResp = responseEntity.getBody();
////		} else {
////			// handle the exception based on error response from service
////		}
//
//		if (responseEntity != null && responseEntity.getStatusCode() != null) {
//			if (200 == responseEntity.getStatusCode().OK.value()) {
//				enrollmentResp = responseEntity.getBody();
//			}
//		}
//		System.out.println("enrollmentResp from EnrollmentServiceClient is :" + enrollmentResp);
//		return enrollmentResp;
//	}
	
	@Override
	public EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest) {
	    EnrollmentResponse enrollmentResp = null;

	    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	    headers.add("authToken", "@#$%^&*(*&^%");
	    headers.add("channelid", "app");
	    headers.add("clientId", "coms");
	    headers.add("correlationId", UUID.randomUUID().toString().substring(0, 16));
	    headers.add("msgTs", new Date().toString());

	    HttpEntity<EnrollmentRequest> requestEntity = new HttpEntity<>(enrollmentRequest, headers);

	    ResponseEntity<EnrollmentResponse> responseEntity = restTemplate.exchange(
	            enrollmentSvcUri,
	            HttpMethod.POST,
	            requestEntity,
	            EnrollmentResponse.class
	    );

	    if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
	        enrollmentResp = responseEntity.getBody();
	    }

	    System.out.println("enrollmentResp from EnrollmentServiceClient is :" + enrollmentResp);
	    return enrollmentResp;
	}

//	
//	public static void main(String[] args)
//	{
//		EnrollmentServiceClientImpl enrollmentServiceClientImpl = new EnrollmentServiceClientImpl();
//		
//		EnrollmentRequest enrollmentRequest = new EnrollmentRequest(); 
//		enrollmentRequest.setCardnum("7564983450648734");
//		enrollmentRequest.setDate("16-07-2025");
//		enrollmentRequest.setName("Deepak");
//		
//		EnrollmentResponse enrollmentResp = new EnrollmentResponse();
//		
//		System.out.println("Enrollment Response is : " + enrollmentResp);
//	}

}
