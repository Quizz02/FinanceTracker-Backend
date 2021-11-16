package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GastoFinalRepository extends JpaRepository<GastoFinal,Long> {
    List<GastoFinal> findAllByFacturaId(Long facturaId);
    List<GastoFinal> findAllByLetraId(Long letraId);
    List<GastoFinal> findAllByReciboId(Long reciboId);

    Optional<GastoFinal> findGastoFinalByFacturaAndId(Long facturaId,Long gastofinalId);
    Optional<GastoFinal> findGastoFinalByLetraAndId(Long letraId,Long gastofinalId);
    Optional<GastoFinal> findGastoFinalByReciboAndId(Long reciboId,Long gastofinalId);



}
