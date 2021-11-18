package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GIFService {
    GastoInicial creategfbyfacturaid(Long facturaId, GastoInicial gastoFinal);
    List<GastoInicial> getallgastobyFacturaId(Long facturaid);
    Optional<GastoInicial> getgfbyidandfacturaid(Long facturaId, Long gastofinalId);
    ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId);
    Optional<GastoInicial> getGFbyId(Long gastofinalid);
}
