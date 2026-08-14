package com.moneybags.kycservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateKycRequest(

        @NotNull
        Long cifId,

        @NotBlank
        @Size(max = 200)
        String customerName,

        LocalDate dateOfBirth,

        @Size(max = 20)
        String mobileNumber,

        @Email
        @Size(max = 255)
        String email,

        @Size(max = 20)
        String panNumber,

        @Size(max = 20)
        String aadhaarNumber,

        @Size(max = 500)
        String addressLine1,

        @Size(max = 500)
        String addressLine2,

        @Size(max = 100)
        String city,

        @Size(max = 100)
        String state,

        @Size(max = 20)
        String postalCode,

        @Size(max = 100)
        String country,

        @NotBlank
        @Size(max = 100)
        String initiatedBy

) {
}