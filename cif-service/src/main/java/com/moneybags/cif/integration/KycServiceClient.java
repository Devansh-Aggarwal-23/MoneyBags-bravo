package com.moneybags.cif.integration;

import com.moneybags.cif.dto.request.KycVerificationRequest;
import com.moneybags.cif.exception.KycServiceUnavailableException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
public class KycServiceClient {

    private final RestClient restClient;

    public KycServiceClient(
            @Qualifier("loadBalancedRestClientBuilder")
            RestClient.Builder restClientBuilder
    ) {
        this.restClient = restClientBuilder
                .baseUrl("http://kyc-service")
                .build();
    }

    public void initiateKycVerification(KycVerificationRequest request) {
        try {
            restClient.post()
                    .uri("/api/v1/kycs")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .toBodilessEntity();

        } catch (RestClientException | IllegalStateException exception) {
            throw new KycServiceUnavailableException(
                    "Unable to initiate KYC verification",
                    exception
            );
        }
    }
}