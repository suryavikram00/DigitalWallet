/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model;

/**
 *
 * @author NMSLAP570
 */
public class FixedDeposit extends Wallet {
    
    private Integer numberOfWalletTransaction;

    public FixedDeposit(String name, Float balance) {
        super(name, balance);
        numberOfWalletTransaction = 0;
    }

    public Integer getNumberOfWalletTransaction() {
        return numberOfWalletTransaction;
    }

    public void setNumberOfWalletTransaction(Integer numberOfWalletTransaction) {
        this.numberOfWalletTransaction = numberOfWalletTransaction;
    }
    
    
    
}
