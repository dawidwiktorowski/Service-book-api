package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Cannot find id owner")
public class OwnerNotFoundException extends RuntimeException {
}
