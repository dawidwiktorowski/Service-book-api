package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.stereotype.Service;

@Service
public class OwnerDtoMapper {

    static OwnerDto toDto(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(owner.getId());
        ownerDto.setFirstName(owner.getFirstName());
        ownerDto.setLastName(owner.getLastName());
        ownerDto.setPhoneNumber(owner.getPhoneNumber());
        ownerDto.setPesel(owner.getPesel());
        return ownerDto;
    }

   static Owner toEntity(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setId(ownerDto.getId());
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setPhoneNumber(ownerDto.getPhoneNumber());
        owner.setPesel(ownerDto.getPesel());
        return owner;
    }
}
