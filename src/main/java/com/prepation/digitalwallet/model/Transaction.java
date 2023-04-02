/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model;

/**
 *
 * @author NMSLAP570
 */
public class Transaction {
    
    private Wallet senderWallet;
    
    private Wallet receiverWallet;
    
    private Float transactionAmount;

    public Transaction(Wallet senderWallet, Wallet receiverWallet, Float transactionAmount) {
        this.senderWallet = senderWallet;
        this.receiverWallet = receiverWallet;
        this.transactionAmount = transactionAmount;
    }
    
    
    
    public Transaction transferMoney() {
        if(this.transactionAmount < 0.0001F){
            System.out.println("The transaction cannot take place as the transaction amount is less than 0.0001FK Rupee ");
            return null;
        }
        // when the user doesn't have enough balance we can reject the transaction
        if(this.senderWallet.getBalance() < this.transactionAmount){
            System.out.println("The transaction cannot take place as the user doesn't have sufficient balance");
            return null;
        }
        
        this.senderWallet.setBalance(new Long(Math.subtractExact(this.senderWallet.getBalance().longValue(), transactionAmount.longValue())).floatValue());
        this.receiverWallet.setBalance(new Long(Math.addExact(this.receiverWallet.getBalance().longValue(), transactionAmount.longValue())).floatValue());
        
        // add this transaction to both the sender wallet and the receiver wallet
        this.senderWallet.addTransaction(this);
        this.receiverWallet.addTransaction(this);    
        
        // if fixed deposit is availed by either the sender or receiver then increement the number of transactions
        this.senderWallet.increementTransactionCountPostFixedDeposit();
        this.receiverWallet.increementTransactionCountPostFixedDeposit();
        
        return this;
    }

    public Wallet getSenderWallet() {
        return senderWallet;
    }

    public Wallet getReceiverWallet() {
        return receiverWallet;
    }

    public Float getTransactionAmount() {
        return transactionAmount;
    }
    
}
