package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByPesel(String pesel);

    List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
