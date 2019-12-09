package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Wallet;
import com.netcracer.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Wallet> getAllUsers(){
        return walletService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Wallet saveUser(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }

    @RequestMapping(value = "/rep/{idWallet}", method = RequestMethod.POST)
    public void replenishmentOfFund(@PathVariable(name = "idWallet") Integer idWallet, @RequestBody String money) {
        Double numMoney = Double.valueOf(money);
        walletService.replenishmentOfFunds(idWallet, numMoney);
    }
}
