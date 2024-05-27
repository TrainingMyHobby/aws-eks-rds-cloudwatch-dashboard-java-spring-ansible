package com.tmh.aws.solutions.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("ALL")
@Getter
@Setter
@Entity(name = "TradeInfo")
public class TradeInfo extends BaseModel {

    @Column(name = "customer_id")
    private Long customerId;

}
