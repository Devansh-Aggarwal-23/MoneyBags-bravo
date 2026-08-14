package com.moneybags.kycservice.mapper;

import com.moneybags.kycservice.dto.request.CreateKycRequest;
import com.moneybags.kycservice.dto.response.KycDocumentResponse;
import com.moneybags.kycservice.dto.response.KycResponse;
import com.moneybags.kycservice.entity.Kyc;
import com.moneybags.kycservice.entity.KycDocument;
import com.moneybags.kycservice.enums.CifSyncStatus;
import com.moneybags.kycservice.enums.KycStatus;
import org.springframework.stereotype.Component;

@Component
public class KycMapper {

    public Kyc toEntity(CreateKycRequest request) {

        Kyc kyc = new Kyc();

        kyc.setCifId(request.cifId());
        kyc.setCustomerName(request.customerName());
        kyc.setDateOfBirth(request.dateOfBirth());
        kyc.setMobileNumber(request.mobileNumber());
        kyc.setEmail(request.email());
        kyc.setPanNumber(request.panNumber());
        kyc.setAadhaarNumber(request.aadhaarNumber());
        kyc.setAddressLine1(request.addressLine1());
        kyc.setAddressLine2(request.addressLine2());
        kyc.setCity(request.city());
        kyc.setState(request.state());
        kyc.setPostalCode(request.postalCode());
        kyc.setCountry(request.country());

        kyc.setInitiatedBy(request.initiatedBy());

        kyc.setKycStatus(KycStatus.PENDING);

        kyc.setCifSyncStatus(
                CifSyncStatus.PENDING
        );

        kyc.setSyncRetryCount(0);

        return kyc;
    }

    public KycResponse toResponse(Kyc kyc) {

        return new KycResponse(
                kyc.getKycId(),
                kyc.getCifId(),
                kyc.getCustomerName(),
                kyc.getDateOfBirth(),
                kyc.getMobileNumber(),
                kyc.getEmail(),
                kyc.getPanNumber(),
                kyc.getAadhaarNumber(),
                kyc.getAddressLine1(),
                kyc.getAddressLine2(),
                kyc.getCity(),
                kyc.getState(),
                kyc.getPostalCode(),
                kyc.getCountry(),
                kyc.getKycStatus(),
                kyc.getDecision(),
                kyc.getRejectionReason(),
                kyc.getMismatchReason(),
                kyc.getInitiatedBy(),
                kyc.getReviewedBy(),
                kyc.getInitiatedAt(),
                kyc.getReviewedAt(),
                kyc.getCifSyncStatus(),
                kyc.getSyncRetryCount(),
                kyc.getCifSyncedAt(),
                kyc.getCreatedAt(),
                kyc.getUpdatedAt()
        );
    }

    public KycDocumentResponse toDocumentResponse(
            KycDocument document) {

        return new KycDocumentResponse(
                document.getDocumentId(),
                document.getKyc().getKycId(),
                document.getDocumentType(),
                document.getOriginalFileName(),
                document.getContentType(),
                document.getFileSizeBytes(),
                document.getVerificationStatus(),
                document.getVerificationRemarks(),
                document.getVerifiedBy(),
                document.getVerifiedAt(),
                document.getUploadedAt()
        );
    }
}