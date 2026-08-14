package com.moneybags.kycservice.integration.cif;

import com.moneybags.kycservice.enums.KycStatus;
import com.moneybags.kycservice.exception.ExternalServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CifClient {

    private final RestClient restClient;

    public CifClient(
            RestClient.Builder restClientBuilder,
            @Value("${services.cif.base-url}") String cifBaseUrl
    ) {

        this.restClient = restClientBuilder
                .baseUrl(cifBaseUrl)
                .build();
    }

    public void updateKycStatus(
            Long cifId,
            KycStatus kycStatus
    ) {

        CifStatusUpdateRequest request =
                new CifStatusUpdateRequest(
                        cifId,
                        kycStatus
                );

        try {

            restClient.patch()
                    .uri("/api/v1/cifs/{cifId}/kyc-status", cifId)
                    .body(request)
                    .retrieve()
                    .toBodilessEntity();

        } catch (Exception exception) {

            throw new ExternalServiceException(
                    "Failed to update KYC status in CIF service for cifId: "
                            + cifId,
                    exception
            );
        }
    }
}