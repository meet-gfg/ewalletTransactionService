package com.gfg.ewallet.transaction.dao;


import com.gfg.ewallet.transaction.domain.TransactionStatus;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionStatusMessage {

    private String transactionId;
    private TransactionStatus status;
}
