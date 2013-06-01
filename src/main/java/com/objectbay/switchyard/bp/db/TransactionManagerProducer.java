package com.objectbay.switchyard.bp.db;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.transaction.UserTransaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

public class TransactionManagerProducer {
	 
    @Produces @Named("springPlatformTransactionManager")
    public PlatformTransactionManager create(UserTransaction ut) {
        return new JtaTransactionManager(ut);
    }
 
}