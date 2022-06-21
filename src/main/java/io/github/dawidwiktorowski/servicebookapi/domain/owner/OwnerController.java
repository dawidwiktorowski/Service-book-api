package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("")
    public List<OwnerDto> findAllOwners(@RequestParam (required = false) String lastName) {
        if (lastName != null)
            return ownerService.findOwnerByLastName(lastName);
        else
            return ownerService.findAllOwners();
    }
}
