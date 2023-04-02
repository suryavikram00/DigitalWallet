/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model;

/**
 *
 * @author NMSLAP570
 */
public class FixedDepositWallet extends Wallet {
    
    
    private static final String NAME = "FIXED_DEPOSIT_WALLET";
    
    private static final Float BALANCE = 10000F;
    
    public FixedDepositWallet() {
        super(NAME, BALANCE);
    }
}
