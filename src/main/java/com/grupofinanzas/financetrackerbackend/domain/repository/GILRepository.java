package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GILRepository extends JpaRepository<GIL,Long> {
    List<GIL> findAllByLetraId(Long facturaId);
    Optional<GIL> findGastoFinalByLetraAndId(Long facturaId, Long gastofinalId);
    Optional<GIL> findById(Long gastofinalid);
}
