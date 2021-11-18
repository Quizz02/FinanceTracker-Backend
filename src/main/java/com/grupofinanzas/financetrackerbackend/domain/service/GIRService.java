package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GIR;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GIRService {
    GIR creategfbyfacturaid(Long facturaId, GIR gastoFinal);
    List<GIR> getallgastobyFacturaId(Long facturaid);
    Optional<GIR> getgfbyidandfacturaid(Long facturaId, Long gastofinalId);
    ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId);
    Optional<GIR> getGFbyId(Long gastofinalid);
}
