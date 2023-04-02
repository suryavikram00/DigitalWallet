/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.digitalwallet;

import com.prepation.digitalwallet.model.Bank;
import com.prepation.digitalwallet.model.FixedDepositWallet;
import com.prepation.digitalwallet.model.OfferWallet;
import com.prepation.digitalwallet.model.Wallet;
import com.prepation.digitalwallet.service.IWalletService;
import com.prepation.digitalwallet.service.WalletService;

/**
 *
 * @author NMSLAP570
 */
public class DriverClass {

    public static void main(String args[]) {

        IWalletService walletService = new WalletService();

        Wallet HarryWallet = walletService.createWallet("Harry", 100F);
        Wallet RonWallet = walletService.createWallet("Ron", 95.7F);
        Wallet HermioneWallet = walletService.createWallet("Hermione", 104F);
        Wallet AlbusWallet = walletService.createWallet("Albus", 200F);
        Wallet DracoWallet = walletService.createWallet("Draco", 500F);

        Bank bank = new Bank();
        bank.addWallet(HarryWallet);
        bank.addWallet(RonWallet);
        bank.addWallet(HermioneWallet);
        bank.addWallet(AlbusWallet);
        bank.addWallet(DracoWallet);
        bank.addWallet(new OfferWallet());
        bank.addWallet(new FixedDepositWallet());
        
        

        walletService.transferMoney(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Albus"))),
                bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Draco"))), 30F,
                bank.getWallet().get(bank.getWallet().indexOf(new OfferWallet())),
                bank.getWallet().get(bank.getWallet().indexOf(new FixedDepositWallet())));

        walletService.transferMoney(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Hermione"))),
                bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Harry"))), 2F,
                bank.getWallet().get(bank.getWallet().indexOf(new OfferWallet())),
                bank.getWallet().get(bank.getWallet().indexOf(new FixedDepositWallet())));

        walletService.transferMoney(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Albus"))),
                bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Ron"))), 5F,
                bank.getWallet().get(bank.getWallet().indexOf(new OfferWallet())),
                bank.getWallet().get(bank.getWallet().indexOf(new FixedDepositWallet()))
        );
        
        walletService.createFixedDeposit(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Draco"))), 100F);
        
        walletService.transferMoney(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Albus"))),
                bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Draco"))), 30F,
                bank.getWallet().get(bank.getWallet().indexOf(new OfferWallet())),
                bank.getWallet().get(bank.getWallet().indexOf(new FixedDepositWallet())));
        
        walletService.transferMoney(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Hermione"))),
                bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Draco"))), 2F,
                bank.getWallet().get(bank.getWallet().indexOf(new OfferWallet())),
                bank.getWallet().get(bank.getWallet().indexOf(new FixedDepositWallet())));
        
        walletService.offerTwo(bank.getWallet());       

        walletService.accountStatement(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Harry"))));
        walletService.accountStatement(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Albus"))));
        walletService.accountStatement(bank.getWallet().get(bank.getWallet().indexOf(new Wallet("Draco"))));

        walletService.overview(bank.getWallet());

    }

}
