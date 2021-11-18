package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.GFLFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GFLRepository extends JpaRepository<GFLFinal,Long> {
    List<GFLFinal> findAllByLetraId(Long facturaId);
    Optional<GFLFinal> findGastoFinalByLetraAndId(Long facturaId, Long gastofinalId);
    Optional<GFLFinal> findById(Long gastofinalid);
}
