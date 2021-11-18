package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.GFR;
import com.grupofinanzas.financetrackerbackend.domain.model.GIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GFRRepository extends JpaRepository<GFR,Long> {
    List<GFR> findAllByReciboHonorarioId(Long facturaId);
    Optional<GFR> findGastoFinalByReciboHonorarioAndId(Long facturaId, Long gastofinalId);
    Optional<GFR> findById(Long gastofinalid);
}

