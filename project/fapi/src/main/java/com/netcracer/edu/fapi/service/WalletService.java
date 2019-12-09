package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> findAll();
    Wallet save(Wallet wallet);
    //void dalete(Integer idWallet);
    void replenishmentOfFunds(Integer idWallet, Double money);
}
