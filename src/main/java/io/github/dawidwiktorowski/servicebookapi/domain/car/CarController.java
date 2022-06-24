package io.github.dawidwiktorowski.servicebookapi.domain.car;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findById(@PathVariable Long id) {
        return carService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public List<CarDto> findAll(@RequestParam(required = false) String text) {
        if (text != null) {
            return carService.findAllByMarkOrNumberVin(text);
        } else {
            return carService.findAll();
        }
    }

    @PostMapping("")
    public ResponseEntity<CarDto> save(@RequestBody CarDto car) {
        if (car.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saved object cannot have id set");
        CarDto savedCar = carService.save(car);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCar)
                .toUri();
        return ResponseEntity.created(location).body(savedCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@PathVariable Long id, @RequestBody CarDto carDto) {
        if (!id.equals(carDto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt musi być taki sam");
        CarDto updatedCar = carService.update(carDto);
        return ResponseEntity.ok(updatedCar);
    }
}
