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
public class WalletUpdateRequest {

    private Integer userId;
    private Double amount;
    private boolean withdraw;
    private String description;


    public Transaction toTransaction(){
      return  Transaction.builder().amount(amount)
                .senderId(withdraw?-1:userId)
                .receiverId(withdraw?userId:-1)
              .status(TransactionStatus.PENDING)
              .description(description)
              .transactionId(UUID.randomUUID().toString()).build();
    }

    /**
     * When user is adding money:
     *  sender party: userId;
     *  receiver party: application
     *
     *  When user is withdrawing moeny:
     *  sender party: application
     *  receiver party: userId
     * */
}

