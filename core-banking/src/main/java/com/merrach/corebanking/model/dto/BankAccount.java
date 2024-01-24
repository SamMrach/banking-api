package com.merrach.corebanking.model.dto;

import com.merrach.corebanking.model.AccountStatus;
import com.merrach.corebanking.model.AccountType;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BankAccount {
    private Long id;
    private String number;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    private User user;
}
