package com.gfg.ewallet.transaction.dao;

import com.gfg.ewallet.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransactionMessage{

    private String transactionId;
    private int senderId;
    private int receiverId;
    private double amount;
    private boolean isWithdraw;

}
