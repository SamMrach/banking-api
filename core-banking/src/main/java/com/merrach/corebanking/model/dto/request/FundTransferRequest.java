package com.merrach.corebanking.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FundTransferRequest {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
