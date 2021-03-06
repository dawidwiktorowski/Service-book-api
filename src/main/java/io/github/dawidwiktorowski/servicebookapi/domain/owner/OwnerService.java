package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import io.github.dawidwiktorowski.servicebookapi.domain.assignment.OwnerAssignmentDto;
import io.github.dawidwiktorowski.servicebookapi.domain.assignment.OwnerAssignmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    Optional<OwnerDto> findById(Long id) {
        return ownerRepository.findById(id).map(OwnerDtoMapper::toDto);
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

    OwnerDto save(OwnerDto owner) {
        Optional<Owner> ownerByPesel = ownerRepository.findByPesel(owner.getPesel());
        ownerByPesel.ifPresent(o -> {
            throw new DuplicatePeselException();
        });
        Owner ownerEntity = OwnerDtoMapper.toEntity(owner);
        Owner savedOwner = ownerRepository.save(ownerEntity);
        return OwnerDtoMapper.toDto(savedOwner);
    }

    OwnerDto update (OwnerDto owner){
        Optional<Owner> ownerByPesel = ownerRepository.findByPesel(owner.getPesel());
        ownerByPesel.ifPresent(o -> {
            if (!o.getId().equals(owner.getId()))
                throw new DuplicatePeselException();
        });
        return mapAndSaveOwner(owner);
    }

    private OwnerDto mapAndSaveOwner(OwnerDto owner) {
        Owner ownerEntity = OwnerDtoMapper.toEntity(owner);
        Owner savedOwner = ownerRepository.save(ownerEntity);
        return OwnerDtoMapper.toDto(savedOwner);
    }

    List<OwnerAssignmentDto> getOwnerAssignments(Long ownerId){
        return ownerRepository.findById(ownerId)
                .map(Owner::getAssignments)
                .orElseThrow(OwnerNotFoundException::new)
                .stream()
                .map(OwnerAssignmentMapper::toDto)
                .collect(Collectors.toList());
    }

}
