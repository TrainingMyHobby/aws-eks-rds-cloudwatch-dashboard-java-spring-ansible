package com.tmh.aws.solutions.services;

import com.tmh.aws.solutions.models.TradeHeader;
import com.tmh.aws.solutions.dao.TradeHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeHeaderService {

    @Autowired
    private TradeHeaderRepository tradeHeaderRepository;

    public List<TradeHeader> getAll() {
        return tradeHeaderRepository.findAll();
    }

    public TradeHeader getById(Long id) {
        return tradeHeaderRepository.findById(id).orElse(null);
    }

    public TradeHeader save(TradeHeader tradeHeader) {
        return tradeHeaderRepository.save(tradeHeader);
    }

    public void delete(Long id) {
        tradeHeaderRepository.deleteById(id);
    }
}