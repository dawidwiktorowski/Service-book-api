package io.github.dawidwiktorowski.servicebookapi.domain.car;

public class CarDtoMapper {

    static CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getMark(),
                car.getModel(),
                car.getNumberVin(),
                car.getOwner()
        );
    }

    static Car toEntity(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getMark(),
                carDto.getModel(),
                carDto.getNumberVin(),
                carDto.getOwner()
        );
    }
}
