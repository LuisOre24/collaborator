package com.devloc.managementsof.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Subsidiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubsidiary;
    @NotBlank(message = "Campo obligatorio")
    @Size(min=5, max = 5, message = "El codigo debe tener 5 dígitos")
    @Column(nullable = false, length = 5, unique = true)
    private String codSubsidiary;
    @NotBlank
    @Size(min = 5, message = "EL campo debe tener al menos 5 caracteres")
    @Column(nullable = false, length = 50, unique = true)
    private String nameSubsidiary;
    @Size(min = 5, message = "El campo debe contener al menos 5 dígitos")
    @Column(nullable = false, length = 300)
    private String address;
    @NotNull(message = "campo obligatorio")
    @ManyToOne
    @JoinColumn(name="id_company", nullable = false, foreignKey = @ForeignKey(name="fk_subsidiary_company"))
    private Company company;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean status;

    public Integer getIdSubsidiary() {
        return idSubsidiary;
    }

    public void setIdSubsidiary(Integer idSubsidiary) {
        this.idSubsidiary = idSubsidiary;
    }

    public String getCodSubsidiary() {
        return codSubsidiary;
    }

    public void setCodSubsidiary(String codSubsidiary) {
        this.codSubsidiary = codSubsidiary;
    }

    public String getNameSubsidiary() {
        return nameSubsidiary;
    }

    public void setNameSubsidiary(String nameSubsidiary) {
        this.nameSubsidiary = nameSubsidiary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
