package io.github.dawidwiktorowski.servicebookapi.domain.car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map(CarDtoMapper::map)
                .toList();
    }

    public List<CarDto>findByMark(String mark){
        return carRepository.findAllByMarkContainingIgnoreCase(mark)
                .stream()
                .map(CarDtoMapper::map)
                .collect(Collectors.toList());
    }
}
