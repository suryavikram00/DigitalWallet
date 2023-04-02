/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class Bank {
    
    private List<Wallet> wallet;
    
    public List<Wallet> addWallet(Wallet wallet) {
        if(this.wallet == null){
            this.wallet = new LinkedList<>();
        }
        this.wallet.add(wallet);
        return this.wallet;
    }

    public List<Wallet> getWallet() {
        if(this.wallet == null){
            this.wallet = new LinkedList<>();
        }
        return wallet;
    }

    public void setWallet(List<Wallet> wallet) {
        this.wallet = wallet;
    }
    
    
    
}
