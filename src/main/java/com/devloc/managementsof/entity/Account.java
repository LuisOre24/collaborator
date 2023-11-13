package com.devloc.managementsof.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAccount;
    @Column(nullable = false, length = 50, unique = true)
    private String accountUser;
    @Column(nullable = false, length = 30)
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = true, foreignKey = @ForeignKey(name = "fk_account_employee"))
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="id_account_type", nullable=false, foreignKey = @ForeignKey(name = "fk_account_account_type"))
    private AccountType accountType;
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;

    private boolean status;


    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee(){
        return employee;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}

