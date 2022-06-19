package io.github.dawidwiktorowski.servicebookapi.domain.car;

public class CarDto {

    private Long id;
    private String mark;
    private String model;
    private String numberVin;
    private String owner;

    public CarDto(Long id, String mark, String model, String numberVin, String owner) {
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

    public void setNumberVin(String numberVin) {
        this.numberVin = numberVin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}