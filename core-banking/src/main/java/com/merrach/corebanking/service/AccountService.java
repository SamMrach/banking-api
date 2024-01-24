package com.merrach.corebanking.service;

import com.merrach.corebanking.model.dto.BankAccount;
import com.merrach.corebanking.model.dto.UtilityAccount;
import com.merrach.corebanking.model.entity.BankAccountEntity;
import com.merrach.corebanking.model.entity.UtilityAccountEntity;
import com.merrach.corebanking.model.mapper.BankAccountMapper;
import com.merrach.corebanking.model.mapper.UtilityAccountMapper;
import com.merrach.corebanking.repository.BankAccountRepository;
import com.merrach.corebanking.repository.UtilityAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private BankAccountMapper bankAccountMapper = new BankAccountMapper();
    private UtilityAccountMapper utilityAccountMapper = new UtilityAccountMapper();

    private final BankAccountRepository bankAccountRepository;
    private final UtilityAccountRepository utilityAccountRepository;

    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity entity = bankAccountRepository.findByNumber(accountNumber).get();
        return bankAccountMapper.convertToDto(entity);
    }

    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).get();
        return utilityAccountMapper.convertToDto(utilityAccountEntity);
    }

    public UtilityAccount readUtilityAccount(Long id){
        return utilityAccountMapper.convertToDto(utilityAccountRepository.findById(id).get());
    }
}
