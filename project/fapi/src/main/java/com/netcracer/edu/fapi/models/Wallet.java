package com.netcracer.edu.fapi.models;

public class Wallet {

    private Integer idWallet;
    private Double money;

    public Wallet() {
    }

    public Wallet(Integer idWallet, Double money) {
        this.idWallet = idWallet;
        this.money = money;
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
}
