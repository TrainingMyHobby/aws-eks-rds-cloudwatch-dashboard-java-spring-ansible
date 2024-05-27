package com.tmh.aws.solutions.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "TradeHeader")
public class TradeHeader extends BaseModel {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "trade_info_id")
    private Long tradeInfoId;
}
