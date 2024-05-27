package com.tmh.aws.solutions.models;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("JpaDataSourceORMInspection")
@Getter
@Setter
@Entity(name = "TradeLine")
public class TradeLine extends BaseModel {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "trade_header_id")
    private Long tradeHeaderId;

    @Column(name = "trade_info_id")
    private Long tradeInfoId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "quantity")
    private Integer quantity;
}
