package io.github.dawidwiktorowski.servicebookapi.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

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
        String text = "Volkswagen";

        //when
        underTest.findAllByMarkOrNumberVin(text);

        //then
        verify(carRepository).findAllByMarkOrNumberVin(text);
    }
}