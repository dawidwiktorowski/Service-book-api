package io.github.dawidwiktorowski.servicebookapi.domain.car;

public class CarDtoMapper {

    static CarDto map (Car car){
        return new CarDto(
                car.getId(),
                car.getMark(),
                car.getModel(),
                car.getNumberVin(),
                car.getOwner().getLastName()
        );
    }
}
