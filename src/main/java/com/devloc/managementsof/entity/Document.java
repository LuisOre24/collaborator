package com.devloc.managementsof.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocument;
    @NotEmpty(message = "El campo es obligatorio")
    @Size(min = 3, message = "Ingrese más de 3 caracteres")
    @Column(nullable = false, unique = true, length = 40)
    private String documentDesc;

    @NotEmpty(message = "El campo es obligatorio")
    @Size(min = 2, max = 3, message = "el campo solo debe contener entre 2 y 3 caracteres")
    @Column(nullable = false, unique = true, length = 3)
    private String abbreviation;

    @Min(5)
    @Max(20)
    @Column(nullable = false)
    private Integer numberCharacters;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean status;

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getDocumentDesc() {
        return documentDesc;
    }

    public void setDocumentDesc(String documentDesc) {
        this.documentDesc = documentDesc;
    }

    public String getAbbreviation() { return abbreviation; }

    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    public Integer getNumberCharacters() { return numberCharacters; }

    public void setNumberCharacters(Integer numberCharacters) { this.numberCharacters = numberCharacters; }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
