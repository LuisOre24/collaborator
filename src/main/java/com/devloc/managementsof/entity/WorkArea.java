package com.devloc.managementsof.entity;

import jakarta.persistence.*;

@Entity
public class WorkArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idWorkArea;
    @Column(name="desc_work_area", nullable = false, unique = true, length = 100)
    private String descWorkArea;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean status;

    public Integer getIdWorkArea() {
        return idWorkArea;
    }

    public void setIdWorkArea(Integer idWorkArea) {
        this.idWorkArea = idWorkArea;
    }

    public String getDescWorkArea() {
        return descWorkArea;
    }

    public void setDescWorkArea(String descWorkArea) {
        this.descWorkArea = descWorkArea;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
