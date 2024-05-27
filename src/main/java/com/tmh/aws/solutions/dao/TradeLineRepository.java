package com.tmh.aws.solutions.repositories;

import com.tmh.aws.solutions.models.TradeLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeLineRepository extends JpaRepository<TradeLine, Long> {
}