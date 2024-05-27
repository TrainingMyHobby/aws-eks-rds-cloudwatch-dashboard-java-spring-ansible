package com.tmh.aws.solutions.dao;

import com.tmh.aws.solutions.models.TradeHeader;
import com.tmh.aws.solutions.models.TradeLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeHeaderRepository extends JpaRepository<TradeHeader, Long> {
}