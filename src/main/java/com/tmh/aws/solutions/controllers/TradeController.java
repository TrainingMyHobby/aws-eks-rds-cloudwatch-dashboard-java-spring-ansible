package com.tmh.aws.solutions.controllers;

import com.tmh.aws.solutions.dtos.TradeInfoCrudCtx;
import com.tmh.aws.solutions.models.TradeHeader;
import com.tmh.aws.solutions.models.TradeInfo;
import com.tmh.aws.solutions.models.TradeLine;
import com.tmh.aws.solutions.services.TradeHeaderService;
import com.tmh.aws.solutions.services.TradeInfoService;
import com.tmh.aws.solutions.services.TradeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping(path = "/api/v1/trade-management")
public class TradeController {

    @Autowired
    private TradeHeaderService tradeHeaderService;

    @Autowired
    private TradeInfoService tradeInfoService;

    @Autowired
    private TradeLineService tradeLineService;

    @GetMapping("/createTrade")
    public ResponseEntity<TradeInfo> createTrade() {

        TradeInfoCrudCtx tradeInfoCrudCtx = new TradeInfoCrudCtx();
        TradeInfo tradeInfo = new TradeInfo();
        long customerId = ThreadLocalRandom.current().nextLong(1, 101);
        tradeInfo.setCustomerId(customerId);
        tradeInfoCrudCtx.setTradeInfo(tradeInfo);

        tradeInfo = tradeInfoService.save(tradeInfoCrudCtx);
        tradeInfoCrudCtx.setTradeInfo(tradeInfo);

        TradeHeader tradeHeader = new TradeHeader();
        tradeInfoCrudCtx.setTradeHeader(tradeHeader);
        tradeHeader.setTradeInfoId(tradeInfo.getId());

        tradeHeader = tradeHeaderService.save(tradeHeader);
        tradeInfoCrudCtx.setTradeHeader(tradeHeader);

        TradeLine tradeLine = new TradeLine();
        tradeLine.setTradeHeaderId(tradeHeader.getId());
        tradeLine.setTradeInfoId(tradeInfo.getId());
        tradeInfoCrudCtx.setTradeLines(Collections.singleton(tradeLine));

        tradeLineService.save(tradeLine);

        return ResponseEntity.ok(tradeInfo);
    }
}
