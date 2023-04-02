/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class Wallet {
    
    public static final String CURRENCY = "FKRUPEE";
    
    private String name;
    
    private Float balance;        
    
    private List<Transaction> transactionList;
    
    private FixedDeposit fixedDeposit;

    public Wallet(String name, Float balance) {
        this.name = name;
        if(balance < 0F){
            balance = 0F;
        }
        this.balance = balance;
    }

    public Wallet(String name) {
        this.name = name;
    }

    public void setBalance(Float balance) {
        if(balance < 0F){
            balance = 0F;
        }
        this.balance = balance;
    }

    public Float getBalance() {
        return balance;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wallet other = (Wallet) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    public List<Transaction> addTransaction(Transaction transaction){
        if(this.transactionList == null ){
            this.transactionList = new LinkedList<>();
        }
        this.transactionList.add(transaction);        
        return this.transactionList;
    }

    public List<Transaction> getTransactionList() {
        if(this.transactionList == null ){
            this.transactionList = new LinkedList<>();
        }
        return transactionList;
    }

    public String getName() {
        return name;
    }

    public FixedDeposit getFixedDeposit() {
        return fixedDeposit;
    }

    public void setFixedDeposit(FixedDeposit fixedDeposit) {
        this.fixedDeposit = fixedDeposit;
    }
    
    public void increementTransactionCountPostFixedDeposit(){
        if(this.fixedDeposit == null){
            return;
        }
        if(this.balance < this.fixedDeposit.getBalance()){
            // dissolve the fixed deposit
            this.fixedDeposit = null;
        }        
        // increement the number of transaction post the fixed deposit has opened
        this.fixedDeposit.setNumberOfWalletTransaction(this.fixedDeposit.getNumberOfWalletTransaction() + 1);
    }
    
    
}
