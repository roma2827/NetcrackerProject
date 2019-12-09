package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> findAll();
    Wallet save(Wallet wallet);
    //void dalete(Integer idWallet);
    void replenishmentOfFunds(Integer idWallet, Double money);
}
