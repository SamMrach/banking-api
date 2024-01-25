package com.merrach.fundtransfer.repository;

import com.merrach.fundtransfer.model.entity.FundTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundTransferRepository extends JpaRepository<FundTransferEntity,Long> {
}
