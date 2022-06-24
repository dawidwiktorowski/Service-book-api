package io.github.dawidwiktorowski.servicebookapi.domain.car;

public class CarDtoMapper {

    static CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setMark(car.getMark());
        carDto.setModel(car.getModel());
        carDto.setNumberVin(car.getNumberVin());
        return carDto;
    }

    static Car toEntity(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setMark(carDto.getMark());
        car.setModel(carDto.getModel());
        car.setNumberVin(carDto.getNumberVin());
        return car;
    }
}
