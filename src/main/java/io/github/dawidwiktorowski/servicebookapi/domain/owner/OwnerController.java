package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> findById(@PathVariable Long id) {
        return ownerService.findByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public List<OwnerDto> findAllOwners(@RequestParam(required = false) String lastName) {
        if (lastName != null)
            return ownerService.findOwnerByLastName(lastName);
        else
            return ownerService.findAllOwners();
    }

    @PostMapping("")
    public ResponseEntity<OwnerDto> save(@RequestBody OwnerDto owner) {
        if (owner.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saved object cannot have id set");
        OwnerDto savedOwner = ownerService.save(owner);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedOwner.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedOwner);
    }
}
