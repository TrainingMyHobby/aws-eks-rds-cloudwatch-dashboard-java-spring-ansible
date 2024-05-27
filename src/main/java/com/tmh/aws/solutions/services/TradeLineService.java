package com.tmh.aws.solutions.services;

import com.tmh.aws.solutions.models.TradeLine;
import com.tmh.aws.solutions.repositories.TradeLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeLineService {

    @Autowired
    private TradeLineRepository tradeLineRepository;

    public List<TradeLine> getAll() {
        return tradeLineRepository.findAll();
    }

    public TradeLine getById(Long id) {
        return tradeLineRepository.findById(id).orElse(null);
    }

    public TradeLine save(TradeLine tradeLine) {
        return tradeLineRepository.save(tradeLine);
    }

    public void delete(Long id) {
        tradeLineRepository.deleteById(id);
    }
}