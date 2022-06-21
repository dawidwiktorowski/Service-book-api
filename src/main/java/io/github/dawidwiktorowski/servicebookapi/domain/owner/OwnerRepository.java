package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
