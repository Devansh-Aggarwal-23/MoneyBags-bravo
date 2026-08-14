package com.moneybags.kycservice.integration.notification;

import com.moneybags.kycservice.enums.KycStatus;

public record NotificationRequest(
        Long cifId,
        KycStatus kycStatus
) {
}