package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GFR;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GFRService {
    GFR creategfbyfacturaid(Long facturaId, GFR gastoFinal);
    List<GFR> getallgastobyFacturaId(Long facturaid);
    Optional<GFR> getgfbyidandfacturaid(Long facturaId, Long gastofinalId);
    ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId);
    Optional<GFR> getGFbyId(Long gastofinalid);
}
