package io.github.dawidwiktorowski.servicebookapi.domain.assignment;

import java.time.LocalDateTime;

public class OwnerAssignmentDto {

    private Long id;
    private LocalDateTime start;
    private LocalDateTime ends;
    private Long carId;
    private String carMark;
    private String carModel;
    private String numberVin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnds() {
        return ends;
    }

    public void setEnds(LocalDateTime ends) {
        this.ends = ends;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getNumberVin() {
        return numberVin;
    }

    public void setNumberVin(String numberVin) {
        this.numberVin = numberVin;
    }
}
