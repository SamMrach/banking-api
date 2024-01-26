package com.merrach.utilitypayment.repository;

import com.merrach.utilitypayment.model.dto.UtilityPayment;
import com.merrach.utilitypayment.model.entity.UtilityPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityPaymentRepository extends JpaRepository<UtilityPaymentEntity, UtilityPayment> {
}
