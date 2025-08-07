package com.barclays.offers.ennrollment.svcclient;

import org.springframework.stereotype.Component;

import com.barclays.offers.model.EnrollmentRequest;
import com.barclays.offers.model.EnrollmentResponse;

@Component
public interface IEnrollmentServiceClient {
	
	EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest);

}
