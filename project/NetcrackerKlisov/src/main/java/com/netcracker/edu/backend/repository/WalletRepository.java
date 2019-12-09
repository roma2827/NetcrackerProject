package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Wallet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Integer> {

    @Modifying
    @Transactional
    @Query("update Wallet w set w.money = w.money + :money where w.idWallet = :idWallet")
    void replenishmentOfFunds(@Param("idWallet") Integer idWallet, @Param("money") Double money);
}
