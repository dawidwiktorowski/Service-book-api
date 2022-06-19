package io.github.dawidwiktorowski.servicebookapi.web;

import io.github.dawidwiktorowski.servicebookapi.domain.car.CarDto;
import io.github.dawidwiktorowski.servicebookapi.domain.car.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class HomeController {

    private final CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public List<CarDto>findAll(){
        return carService.findAll();
    }
}
