package com.barclays.enrollment.ennrollment.svcclient;

import org.springframework.stereotype.Component;

import com.barclays.enrollment.model.EnrollmentRequest;
import com.barclays.enrollment.model.EnrollmentResponse;

@Component
public interface IEnrollmentServiceClient {
	
	EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest);

}
