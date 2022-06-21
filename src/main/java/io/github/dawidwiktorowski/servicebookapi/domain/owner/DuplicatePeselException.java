package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Owner with this number exists")
public class DuplicatePeselException extends RuntimeException {
}
