package com.gfg.ewallet.transaction.service.request;

import com.gfg.ewallet.transaction.domain.Transaction;
import com.gfg.ewallet.transaction.domain.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TransactionRequest {

    private int senderId;
    private int receiverId;
    private double amount;
    private String description;

    public Transaction toTransaction(){
        return Transaction.builder().senderId(senderId)
                .receiverId(receiverId)
                .amount(amount)
                .transactionId(UUID.randomUUID().toString())
                .description(description)
                .status(TransactionStatus.PENDING).build();
    }
}
