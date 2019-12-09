package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<Wallet> findAll(){
        return (List<Wallet>) walletRepository.findAll();
    }

    @Override
    public Wallet save(Wallet wallet){
        return walletRepository.save(wallet);
    }

    /*@Override
    public void delete(Integer idWallet){
        walletRepository.deleteById(idWallet);
    }*/

    @Override
    public void replenishmentOfFunds(Integer idWallet, Double money) {
        walletRepository.replenishmentOfFunds(idWallet, money);
    }
}
