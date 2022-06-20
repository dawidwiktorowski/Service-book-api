package io.github.dawidwiktorowski.servicebookapi.domain.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private CarDto carDto;
    private CarService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CarService(carRepository);
    }

    @Test
    void canGetAllCars() {
        //when
        underTest.findAll();

        //then
        verify(carRepository).findAll();

    }

    @Test
    void findByMark() {
        //given
        String mark = "Volkswagen";

        //when
        underTest.findByMark(mark);

        //then
        verify(carRepository).findAllByMarkContainingIgnoreCase(mark);
    }
}