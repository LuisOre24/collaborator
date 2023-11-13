package com.devloc.managementsof.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPosition;

    @NotEmpty(message = "EL CAMPO ES OBLIGATORIO")
    @Column(nullable = false, length = 50, unique = true)
    private String descPosition;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean status;

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getDescPosition() {
        return descPosition;
    }

    public void setDescPosition(String descPosition) {
        this.descPosition = descPosition;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
