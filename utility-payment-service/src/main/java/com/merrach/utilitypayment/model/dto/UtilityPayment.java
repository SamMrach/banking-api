package com.merrach.utilitypayment.model.dto;

import com.merrach.utilitypayment.model.entity.TransactionStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UtilityPayment {
    private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
    private TransactionStatus status;
}

