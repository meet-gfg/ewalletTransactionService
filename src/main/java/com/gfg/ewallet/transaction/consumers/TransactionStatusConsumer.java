package com.gfg.ewallet.transaction.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.ewallet.transaction.dao.TransactionStatusMessage;
import com.gfg.ewallet.transaction.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionStatusConsumer {

    Logger logger= LoggerFactory.getLogger(TransactionStatusConsumer.class);


    private final String TransactionStatusTopic="TRANS_STATUS";

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ObjectMapper mapper;


    @KafkaListener(topics = TransactionStatusTopic,groupId = "transactionGrp")
    public void updateTransactionStatus(String message) throws JsonProcessingException {
        logger.info("received message -. {}",message);
        TransactionStatusMessage transactionStatusMessage=mapper.readValue(message,TransactionStatusMessage.class);
        transactionService.updateTransaction(transactionStatusMessage);
    }
}
