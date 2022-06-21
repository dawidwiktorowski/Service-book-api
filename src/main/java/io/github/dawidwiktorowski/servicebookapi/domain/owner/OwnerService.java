package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    List<OwnerDto> findAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(OwnerDtoMapper::toDto)
                .toList();
    }

    List<OwnerDto> findOwnerByLastName(String lastName) {
        return ownerRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(OwnerDtoMapper::toDto)
                .toList();
    }
}
