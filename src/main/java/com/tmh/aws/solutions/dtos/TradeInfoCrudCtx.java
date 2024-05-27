package com.tmh.aws.solutions.dtos;

import com.tmh.aws.solutions.models.TradeHeader;
import com.tmh.aws.solutions.models.TradeInfo;
import com.tmh.aws.solutions.models.TradeLine;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class TradeInfoCrudCtx {

    private TradeInfo tradeInfo;
    private TradeHeader tradeHeader;
    private Set<TradeLine> tradeLines;
}
