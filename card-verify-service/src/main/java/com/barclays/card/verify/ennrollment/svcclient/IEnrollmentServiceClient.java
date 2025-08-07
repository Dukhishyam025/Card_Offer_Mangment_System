package com.barclays.card.verify.ennrollment.svcclient;

import org.springframework.stereotype.Component;

import com.barclays.card.verify.model.EnrollmentRequest;
import com.barclays.card.verify.model.EnrollmentResponse;

@Component
public interface IEnrollmentServiceClient {
	
	EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest);

}
