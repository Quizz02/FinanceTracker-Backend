package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.Letra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LetraRepository extends JpaRepository<Letra, Long> {
    List<Letra> findAllByCarteraIdCartera(Long carteraId);
    Optional<Letra> findByIdAndCarteraIdCartera(Long letraId,Long carteraId);
}
