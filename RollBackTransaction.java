package com.vtc.gateway.scoinv2api.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

public class RollBackTransaction {
    private static Logger logger = LoggerFactory.getLogger(RollBackTransaction.class);

    public static void callRollback(){
        logger.info("Call rollback !!!");
        TransactionAspectSupport.currentTransactionStatus()
                .setRollbackOnly();
    }

}
