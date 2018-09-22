package com.capgemini.bankapp;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.exception.LowBalancException;

public class Application {
	public static void main(String[] args) throws LowBalancException {

		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 */
		BankAccountController bankAccountController = context.getBean(BankAccountController.class);
//		bankAccountController.addBankAccount(new BankAccount(123455, "su", "Savings", 20000));
		System.out.println(bankAccountController.getBalance(123456));
//		System.out.println(bankAccountController.withdraw(123456,3000));
//	    bankAccountController.addBankAccount(new BankAccount(123457, "swathi", "current", 30000));
//	    bankAccountController.updateBankAccount(new BankAccount(123457, "swathi", "savings", 30000));
//	    bankAccountController.fundTransfer(123456, 123457, 250);
//	    bankAccountController.deposit(123457, 2000);
		List<BankAccount> bankAccounts = bankAccountController.findAllBankAccounts();
		for (BankAccount bankAccount : bankAccounts) {
			System.out.println(bankAccount);
		}
		bankAccountController.deleteBankAccount(123457);
		
		
		
}
}