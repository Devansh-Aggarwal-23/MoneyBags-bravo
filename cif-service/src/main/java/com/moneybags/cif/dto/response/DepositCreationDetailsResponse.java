package com.moneybags.cif.dto.response;

import com.moneybags.cif.domain.enums.KycStatus;

import java.time.LocalDate;

public record DepositCreationDetailsResponse(

        Long cifId,
        String firstName,
        String lastName,
        LocalDate dob,
        String email,
        String number,
        String address,
        String panNumber,
        KycStatus kycStatus
) {
}