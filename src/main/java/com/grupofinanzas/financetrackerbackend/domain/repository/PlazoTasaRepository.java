package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.PlazoTasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlazoTasaRepository extends JpaRepository<PlazoTasa,Long> {
    Optional<   PlazoTasa> findById(Long id);
}