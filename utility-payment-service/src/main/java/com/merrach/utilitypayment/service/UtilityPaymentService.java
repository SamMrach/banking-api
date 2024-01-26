package com.merrach.utilitypayment.service;

import com.merrach.utilitypayment.mapper.UtilityPaymentMapper;
import com.merrach.utilitypayment.model.dto.UtilityPayment;
import com.merrach.utilitypayment.model.dto.request.UtilityPaymentRequest;
import com.merrach.utilitypayment.model.dto.response.UtilityPaymentResponse;
import com.merrach.utilitypayment.model.entity.TransactionStatus;
import com.merrach.utilitypayment.model.entity.UtilityPaymentEntity;
import com.merrach.utilitypayment.repository.UtilityPaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UtilityPaymentService {
    private final UtilityPaymentRepository utilityPaymentRepository;

    private UtilityPaymentMapper utilityPaymentMapper = new UtilityPaymentMapper();

    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest paymentRequest) {
        log.info("Utility payment processing {}", paymentRequest.toString());

        UtilityPaymentEntity entity = new UtilityPaymentEntity();
        BeanUtils.copyProperties(paymentRequest, entity);
        entity.setStatus(TransactionStatus.PROCESSING);
        UtilityPaymentEntity optUtilPayment = utilityPaymentRepository.save(entity);

        String transactionId = UUID.randomUUID().toString();
        optUtilPayment.setStatus(TransactionStatus.SUCCESS);
        optUtilPayment.setTransactionId(transactionId);

        utilityPaymentRepository.save(optUtilPayment);

        return UtilityPaymentResponse.builder().message("Utility Payment Successfully Processed").transactionId(transactionId).build();
    }

    public List<UtilityPayment> readPayments(Pageable pageable) {
        Page<UtilityPaymentEntity> allUtilPayments = utilityPaymentRepository.findAll(pageable);
        return utilityPaymentMapper.convertToDtoList(allUtilPayments.getContent());
    }
}
