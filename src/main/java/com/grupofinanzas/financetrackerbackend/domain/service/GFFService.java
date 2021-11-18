package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GFFService {
    GastoFinal creategfbyfacturaid(Long facturaId, GastoFinal gastoFinal);
    List<GastoFinal> getallgastobyFacturaId(Long facturaid);
    Optional<GastoFinal> getgfbyidandfacturaid(Long facturaId, Long gastofinalId);
    ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId);
    Optional<GastoFinal> getGFbyId(Long gastofinalid);
}
