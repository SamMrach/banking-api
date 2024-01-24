package com.merrach.corebanking.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SimpleBankingGlobalException extends RuntimeException{
    String message;
    String code;

    public SimpleBankingGlobalException(String message){
        super(message);
    }
}
