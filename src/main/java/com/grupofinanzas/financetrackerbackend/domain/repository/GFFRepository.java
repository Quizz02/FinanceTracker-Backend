package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GFFRepository extends JpaRepository<GastoFinal,Long> {
    List<GastoFinal> findAllByFacturaId(Long facturaId);
    Optional<GastoFinal> findGastoFinalByFacturaAndId(Long facturaId, Long gastofinalId);
    Optional<GastoFinal> findById(Long gastofinalid);

}
