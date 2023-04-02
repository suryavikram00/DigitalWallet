/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.service;

import com.prepation.digitalwallet.model.FixedDeposit;
import com.prepation.digitalwallet.model.Transaction;
import com.prepation.digitalwallet.model.Wallet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class WalletService implements IWalletService {

    @Override
    public Wallet createWallet(String name, Float initialAmount) {
        Wallet wallet = new Wallet(name, initialAmount);
        return wallet;
    }

    @Override
    public void accountStatement(Wallet wallet) {
        System.out.println("The below is the transaction statement for customer :: " + wallet.getName());
        for(Transaction eachTransaction : wallet != null ? wallet.getTransactionList()
                : new LinkedList<Transaction>()){
            // if the user is in sender list then print debit
            if(eachTransaction.getSenderWallet().equals(wallet)){
                System.out.println("Debit Transaction | Sender name :: " + eachTransaction.getSenderWallet().getName() 
                        + " | Receiver Name :: " + eachTransaction.getReceiverWallet().getName()
                        + " | Transaction Amount :: " + eachTransaction.getTransactionAmount());
            }
            
            // if the user is in receiver list then print credit
            if(eachTransaction.getReceiverWallet().equals(wallet)){
                System.out.println("Credit Transaction | Sender name :: " + eachTransaction.getSenderWallet().getName() 
                        + " | Receiver Name :: " + eachTransaction.getReceiverWallet().getName()
                        + " | Transaction Amount :: " + eachTransaction.getTransactionAmount());
            }
        }
        System.out.println("The transaction statement ends for customer :: " + wallet.getName());
    }

    @Override
    public void overview(List<Wallet> walletList) {
        System.out.println("Overview of all the customer wallets");
        for(Wallet eachWallet : walletList){
            System.out.println("Customer Name :: " + eachWallet.getName() + " | Balance :: " + eachWallet.getBalance());
        }
        System.out.println("Ending Overview of all the customer wallets");
    }

    @Override
    public void transferMoney(Wallet senderWallet, Wallet receiverWallet, Float transactionAmount, 
            Wallet offerWallet, Wallet FixedDepositWallet) {
        Transaction transaction = new Transaction(senderWallet, receiverWallet, transactionAmount);
        transaction.transferMoney();
        
        // check for offer one if it is available then create a offer transaction;
        offerOne(transaction, offerWallet);
        
        // check the fixed deposit intereset credit for this transaction
        checkFixedDepositInterest(transaction, FixedDepositWallet);
        
    }

    private Wallet offerOne(Transaction transaction, Wallet offerWallet) {
        Float offerOneCreditAmount = 10F;
        if (transaction.getSenderWallet().getBalance().equals(transaction.getReceiverWallet().getBalance())) {
            // create a transaction which debits amount from offer wallet and adds to sender wallet
            Transaction offerCreditToSenderWallet = new Transaction(offerWallet, transaction.getSenderWallet(), offerOneCreditAmount);
            offerCreditToSenderWallet.transferMoney();

            // create a transaction which debits amount from offer wallet and adds to receiver wallet
            Transaction offerCreditToReceiverWallet = new Transaction(offerWallet, transaction.getReceiverWallet(), offerOneCreditAmount);
            offerCreditToReceiverWallet.transferMoney();

        }

        return offerWallet;
    }

    @Override
    public List<Wallet> offerTwo(List<Wallet> walletList) {                
        return Collections.EMPTY_LIST;
    }

    @Override
    public Wallet createFixedDeposit(Wallet wallet, Float initialAmount) {
        FixedDeposit fixedDeposit = new FixedDeposit(wallet.getName(), initialAmount);
        wallet.setFixedDeposit(fixedDeposit);
        return wallet;
    }

    private void checkFixedDepositInterest(Transaction transaction, Wallet fixedDepositWallet) {
        Float fixedDepositInterestAmount = 10.0F;
        Integer transactionThresholdToGetInterest = 2;
        
        // check the number of transaction post fd creation is greater than 5
        // if yes then add a interest of rupee 10 
        
        // do the same for both the sender and the receiver
        if(transaction.getSenderWallet().getFixedDeposit() != null 
                && transaction.getSenderWallet().getFixedDeposit().getNumberOfWalletTransaction() % transactionThresholdToGetInterest == 0){
            Transaction interestCreditTransaction = new Transaction(fixedDepositWallet, 
                    transaction.getSenderWallet(), fixedDepositInterestAmount);
            interestCreditTransaction.transferMoney();                        
        }
        
        if(transaction.getReceiverWallet().getFixedDeposit() != null 
                && transaction.getReceiverWallet().getFixedDeposit().getNumberOfWalletTransaction() % transactionThresholdToGetInterest == 0){
            Transaction interestCreditTransaction = new Transaction(fixedDepositWallet, 
                    transaction.getReceiverWallet(), fixedDepositInterestAmount);
            interestCreditTransaction.transferMoney();                        
        }
        
    }
    
    

}
