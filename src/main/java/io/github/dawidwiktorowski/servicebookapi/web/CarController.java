package io.github.dawidwiktorowski.servicebookapi.web;

import io.github.dawidwiktorowski.servicebookapi.domain.car.CarDto;
import io.github.dawidwiktorowski.servicebookapi.domain.car.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public List<CarDto> findAll(@RequestParam(required = false) String mark){
        if (mark != null)
            return carService.findByMark(mark);
        else
            return carService.findAll();
    }
}
