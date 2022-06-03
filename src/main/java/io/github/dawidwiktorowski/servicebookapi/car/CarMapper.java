package io.github.dawidwiktorowski.servicebookapi.car;

public class CarMapper {
    static CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setMark(car.getMark());
        carDto.setModel(car.getModel());
        carDto.setRegisterNumber(car.getRegisterNumber());
        return carDto;
    }
}
