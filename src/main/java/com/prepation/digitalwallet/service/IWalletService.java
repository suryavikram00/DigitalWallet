/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prepation.digitalwallet.service;

import com.prepation.digitalwallet.model.Transaction;
import com.prepation.digitalwallet.model.Wallet;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public interface IWalletService {
    
    public Wallet createWallet(String name, Float amount);
    
    public void accountStatement(Wallet wallet);
    
    public void overview(List<Wallet> walletList);
    
    public void transferMoney(Wallet senderWallet, Wallet receiverWallet, Float transactionAmount, 
            Wallet offerWallet, Wallet FixedDepositWallet);        
    
    public List<Wallet> offerTwo(List<Wallet> walletList);
    
    public Wallet createFixedDeposit(Wallet wallet, Float initialAmount);
    
}
