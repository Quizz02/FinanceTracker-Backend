package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GILService {
    GIL creategfbyfacturaid(Long facturaId, GIL gastoFinal);
    List<GIL> getallgastobyFacturaId(Long facturaid);
    Optional<GIL> getgfbyidandfacturaid(Long facturaId, Long gastofinalId);
    ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId);
    Optional<GIL> getGFbyId(Long gastofinalid);
}
