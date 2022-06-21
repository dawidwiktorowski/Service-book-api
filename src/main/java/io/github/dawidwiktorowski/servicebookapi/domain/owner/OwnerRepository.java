package io.github.dawidwiktorowski.servicebookapi.domain.owner;

import org.springframework.data.jpa.repository.JpaRepository;

interface OwnerRepository extends JpaRepository<Owner, Long> {
}
