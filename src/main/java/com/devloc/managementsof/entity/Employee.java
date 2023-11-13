package com.devloc.managementsof.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;
    @NotEmpty(message = "el campo no puede estar vacio")
    @Size(min = 2, message = "El nombre debe contener mínimo 2 dígitos")
    @Column(name="name", nullable = false, length = 255)
    private String name;
    @Column(name="second_name", nullable = false, length = 255)
    private String secondName;
    @NotEmpty(message = "El campo es obligatorio")
    @Size(min = 3, message = "el campo debe contener minimo 3 caracteres")
    @Column(name="last_name", nullable = false, length = 255)
    private String lastname;
    @NotEmpty(message = "El campo es obligatorio")
    @Size(min = 3, message = "el campo debe contener minimo 3 caracteres")
    @Column(name="second_lastname", nullable = false, length = 255)
    private String secondLastname;
    @NotNull(message = "Seleccione un tipo de documento")
    @ManyToOne
    @JoinColumn(name = "id_document", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_document"))
    private Document document;
    @NotEmpty(message = "El campo es obligatorio")
    @Column(name="number_document", nullable = false, length = 20)
    private String numberDocument;
    @NotNull(message="Debe elegir un área de trabajo")
    @ManyToOne
    @JoinColumn(name = "id_work_area", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_work_area"))
    private WorkArea workArea;
    @NotNull(message = "Debe elegir un establecimiento")
    @ManyToOne
    @JoinColumn(name = "id_subsidiary", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_subsidiary"))
    private Subsidiary subsidiary;
    @NotNull(message = "Debe asignar un cargo al colaborador")
    @ManyToOne
    @JoinColumn(name = "id_position", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_position"))
    private Position position;
    @ManyToOne
    @JoinColumn(name = "id_supervisor", referencedColumnName = "idEmployee", foreignKey = @ForeignKey(name = "fk_employee_supervisor"))
    private Employee supervisor;
    @OneToMany(mappedBy = "supervisor")
    private List<Employee> workers;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private UserAccess userAccess;

    private boolean status;

    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;


    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public WorkArea getWorkArea() {
        return workArea;
    }

    public void setWorkArea(WorkArea workArea) {
        this.workArea = workArea;
    }

    public Subsidiary getSubsidiary()  { return subsidiary;}

    public void setSubsidiary(Subsidiary subsidiary) { this.subsidiary = subsidiary; }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public List<Employee> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Employee> workers) {
        this.workers = workers;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public UserAccess getUserAccess(){ return userAccess; }
    public void setUserAccess(UserAccess userAccess){ this.userAccess = userAccess; }

    public String getFullName(){
        String fullName = getName() + " " + getSecondName() + " " + getLastname() + " " + getSecondLastname() ;
        return fullName;
    }
}
