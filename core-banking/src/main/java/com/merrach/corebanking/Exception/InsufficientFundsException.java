package com.merrach.corebanking.Exception;

public class InsufficientFundsException extends SimpleBankingGlobalException{
    public InsufficientFundsException(String message, String code) {
        super(message, code);
    }
}
