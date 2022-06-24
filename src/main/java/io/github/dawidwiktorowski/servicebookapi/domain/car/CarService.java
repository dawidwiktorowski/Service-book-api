package io.github.dawidwiktorowski.servicebookapi.domain.car;

import io.github.dawidwiktorowski.servicebookapi.domain.owner.DuplicatePeselException;
import io.github.dawidwiktorowski.servicebookapi.domain.owner.OwnerDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Optional<CarDto> findById(Long id) {
        return carRepository.findById(id)
                .map(CarDtoMapper::toDto);
    }

    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map(CarDtoMapper::toDto)
                .toList();
    }

    public List<CarDto> findAllByMarkOrNumberVin(String text) {
        return carRepository.findAllByMarkOrNumberVin(text)
                .stream()
                .map(CarDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public CarDto save(CarDto car) {
        Optional<Car> carByNumberVin = carRepository.findByNumberVin(car.getNumberVin());
        carByNumberVin.ifPresent(c -> {
            throw new DuplicateVinException();
        });
        return mapAndSave(car);
    }

    public CarDto update(CarDto car) {
        Optional<Car> carByNumberVin = carRepository.findByNumberVin(car.getNumberVin());
        carByNumberVin.ifPresent(c -> {
            if (!c.getId().equals(car.getId()))
                throw new DuplicateVinException();
        });
        return mapAndSave(car);
    }

    private CarDto mapAndSave(CarDto car) {
        Car carEntity = CarDtoMapper.toEntity(car);
        Car savedCar = carRepository.save(carEntity);
        return CarDtoMapper.toDto(savedCar);
    }
}
