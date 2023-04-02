/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet.model;

/**
 *
 * @author NMSLAP570
 */
public class OfferWallet extends Wallet {
    
    private static final String NAME = "OFFER_WALLET";
    
    private static final Float BALANCE = 10000F;
    
    public OfferWallet() {
        super(NAME, BALANCE);
    }
       
}
