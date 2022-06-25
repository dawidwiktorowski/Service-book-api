package io.github.dawidwiktorowski.servicebookapi.domain.assignment;

import io.github.dawidwiktorowski.servicebookapi.domain.car.Car;

public class OwnerAssignmentMapper {

    public static OwnerAssignmentDto toDto(Assignment assignment) {
        OwnerAssignmentDto dto = new OwnerAssignmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnds(assignment.getEnds());
        Car car = assignment.getCar();
        dto.setCarId(car.getId());
        dto.setCarMark(car.getMark());
        dto.setCarModel(car.getModel());
        dto.setNumberVin(car.getNumberVin());
        return dto;
    }
}
