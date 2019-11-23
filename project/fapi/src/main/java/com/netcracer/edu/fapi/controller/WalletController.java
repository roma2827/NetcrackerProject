package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Wallet;
import com.netcracer.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
