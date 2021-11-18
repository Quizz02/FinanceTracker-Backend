package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.GIR;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GIRRepository extends JpaRepository<GIR,Long> {
    List<GIR> findAllByReciboHonorarioId(Long facturaId);
    Optional<GIR> findGastoFinalByReciboHonorarioAndId(Long facturaId, Long gastofinalId);
    Optional<GIR> findById(Long gastofinalid);
}
