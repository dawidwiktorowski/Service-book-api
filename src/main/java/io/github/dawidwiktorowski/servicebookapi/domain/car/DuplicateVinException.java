package io.github.dawidwiktorowski.servicebookapi.domain.car;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Car with this VIN exists")
public class DuplicateVinException extends RuntimeException {
}
