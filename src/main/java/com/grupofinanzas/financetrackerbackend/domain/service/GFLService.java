package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GFLFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GFLService {

    GFLFinal creategfbyfacturaid(Long facturaId, GFLFinal gastoFinal);
    List<GFLFinal> getallgastobyFacturaId(Long facturaid);
    Optional<GFLFinal> getgfbyidandfacturaid(Long facturaId, Long gastofinalId);
    ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId);
    Optional<GFLFinal> getGFbyId(Long gastofinalid);
}
