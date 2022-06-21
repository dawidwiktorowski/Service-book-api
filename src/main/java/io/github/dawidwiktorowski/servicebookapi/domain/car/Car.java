package io.github.dawidwiktorowski.servicebookapi.domain.car;

import io.github.dawidwiktorowski.servicebookapi.domain.owner.Owner;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String model;
    private String numberVin;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public Car() {
    }

    public Car(Long id, String mark, String model, String numberVin, Owner owner) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.numberVin = numberVin;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberVin() {
        return numberVin;
    }

    public void setNumberVin(String registerNumber) {
        this.numberVin = registerNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
