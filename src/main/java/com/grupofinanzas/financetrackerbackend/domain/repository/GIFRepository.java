package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GIFRepository extends JpaRepository<GastoInicial,Long> {
    List<GastoInicial> findAllByFacturaId(Long facturaId);
    Optional<GastoInicial> findGastoFinalByFacturaAndId(Long facturaId, Long gastofinalId);
    Optional<GastoInicial> findById(Long gastofinalid);

}