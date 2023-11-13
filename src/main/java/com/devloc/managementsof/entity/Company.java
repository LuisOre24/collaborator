package com.devloc.managementsof.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompany;
    @NotBlank(message = "El campo es necesario - 5 dígitos requeridos")
    @Size(min = 5, max = 5, message = "El codigo debe contener 5 dígitos")
    @Column(nullable = false, length = 5, unique = true)
    private String codCompany;
    @NotBlank(message = "Debe ingresar el nombre de la compañia")
    @Size(min = 5, message = "el nombre de la compañia no puede ser mayor de 5 caracteres")
    @Column(nullable = false, length = 300, unique = true)
    private String nameCompany;
    @NotBlank(message = "El campo es requerido")
    @Size(min = 11, max = 11, message = "El campo requiere de 11 dígitos")
    @Column(nullable = false, length = 11, unique = true)
    private String rucCompany;
    @Column(nullable = false, length = 300)
    private String address;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean status;

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(String codCompany) {
        this.codCompany = codCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getRucCompany() {
        return rucCompany;
    }

    public void setRucCompany(String rucCompany) {
        this.rucCompany = rucCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
