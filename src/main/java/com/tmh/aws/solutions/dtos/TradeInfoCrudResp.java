package com.tmh.aws.solutions.dtos;

import com.tmh.aws.solutions.models.TradeHeader;
import com.tmh.aws.solutions.models.TradeInfo;
import com.tmh.aws.solutions.models.TradeLine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeInfoCrudResp {

    private TradeInfo tradeInfo;
    private TradeHeader tradeHeader;
    private TradeLine tradeLine;
}
