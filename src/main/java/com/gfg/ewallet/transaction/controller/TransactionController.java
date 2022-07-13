package com.gfg.ewallet.transaction.controller;

import com.gfg.ewallet.transaction.domain.Transaction;
import com.gfg.ewallet.transaction.service.TransactionService;
import com.gfg.ewallet.transaction.service.request.TransactionRequest;
import com.gfg.ewallet.transaction.service.request.WalletUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/update")
    public String updateWallet(@RequestBody WalletUpdateRequest walletUpdateRequest){
        Transaction transaction=walletUpdateRequest.toTransaction();
        transactionService.postWalletUpdateMessage(walletUpdateRequest.toTransaction());
        return transaction.getTransactionId();

    }

    @PostMapping("/transfer")
    public String performTransaction(@RequestBody TransactionRequest transactionRequest){
        Transaction transaction=transactionRequest.toTransaction();
        transactionService.postWalletUpdateMessage(transactionRequest.toTransaction());
        return transaction.getTransactionId();
    }

}
