package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Wallet> getAllUsers(){
        return walletService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Wallet saveUser(@RequestBody Wallet wallet){
        return walletService.save(wallet);
    }

    /*@RequestMapping(value = "/delete/{idWallet}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable(name = "idWallet") Integer idWallet){
        walletService.delete(idWallet);
    }*/

    @RequestMapping(value = "/rep/{idWallet}", method = RequestMethod.POST)
    public void replenishmentOfFund(@PathVariable(name = "idWallet") Integer idWallet, @RequestBody Double money) {
        walletService.replenishmentOfFunds(idWallet, money);
    }
}
