package com.devloc.managementsof.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAccountType;
    @NotBlank(message = "El campo es obligatorio")
    @Size(min = 3, message = "El campo no puede contener menos de 3 caracteres")
    @Column(nullable = false, length = 50, unique = true)
    private String descAccountType;
    @Size(min = 3, message = "El campo no puede contener menos de 3 caracteres")
    @Column(length = 300)
    private String description;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean status;

    public Integer getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(Integer idAccountType) {
        this.idAccountType = idAccountType;
    }

    public String getDescAccountType() {
        return descAccountType;
    }

    public void setDescAccountType(String descAccountType) {
        this.descAccountType = descAccountType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
