package io.github.dawidwiktorowski.servicebookapi.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c from Car c where lower(c.mark) like lower(concat('%',:search,'%')) " +
           "OR lower(c.numberVin) like (concat('%',:search,'%'))")
    List<Car>findAllByMarkOrNumberVin(String search);

    Optional<Car> findByNumberVin(String numberVin);


}
