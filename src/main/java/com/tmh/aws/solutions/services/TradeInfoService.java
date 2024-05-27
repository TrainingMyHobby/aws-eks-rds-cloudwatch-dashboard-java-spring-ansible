package com.tmh.aws.solutions.services;

import com.tmh.aws.solutions.dao.TradeInfoRepository;
import com.tmh.aws.solutions.dtos.TradeInfoCrudCtx;
import com.tmh.aws.solutions.models.TradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeInfoService {

    @Autowired
    private TradeInfoRepository tradeInfoRepository;

    public List<TradeInfo> getAll() {
        return tradeInfoRepository.findAll();
    }

    public TradeInfo getById(Long id) {
        return tradeInfoRepository.findById(id).orElse(null);
    }

    public TradeInfo save(TradeInfoCrudCtx tradeInfoCrudCtx) {
        return tradeInfoRepository.save(tradeInfoCrudCtx.getTradeInfo());
    }

    public void delete(Long id) {
        tradeInfoRepository.deleteById(id);
    }
}