package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wallet")
    private Integer idWallet;

    @Column
    @NotNull
    private Double money;

    /*@OneToOne(optional = false, mappedBy="wallet")
    public User user;*/

    public Wallet() {
    }

    public Wallet(@NotNull Double money, User user) {
        this.money = money;
//        this.user = user;
    }

    public Integer getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(Integer idWallet) {
        this.idWallet = idWallet;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

//    public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }
}
