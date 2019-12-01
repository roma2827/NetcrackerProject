package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column
    @NotNull
    @Size(max = 10)
    private String role;

    @Basic
    @Column
    @NotNull
    @Size(max = 20)
    private String login;

    @Basic
    @Column
    @NotNull
    @Size(max = 225)
    private String password;

    @OneToOne
    @JoinColumn(name="id_wallet")
    private Wallet wallet;

//    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name="id_ticket", unique = true)
//    private Ticket ticket;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonManagedReference
//    @JsonIgnore
    private Set<Ticket> tickets;

    public User() {
    }

    public User(@NotNull @Size(max = 20) String login, @NotNull @Size(max = 225) String password, Wallet wallet) {
        this.login = login;
        this.password = password;
        this.wallet = wallet;
    }

    public User(@NotNull @Size(max = 10) String role, @NotNull @Size(max = 20) String login, @NotNull @Size(max = 225) String password, Wallet wallet, Set<Ticket> tickets) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.wallet = wallet;
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, password);
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
