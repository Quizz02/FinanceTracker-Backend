package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    Factura createFacturaByCarteraId(Long carteraId, Long plazotasaId, Factura factura);
    List<Factura> getAllFacturasByCarteraId(Long carteraId);
    Optional<Factura> getFacturaByIdAndCarteraId(Long carteraId, Long facturaId);
    Factura updateFactura(Long carteraId, Long facturaId, Factura factura);
    ResponseEntity<?> deleteFactura(Long carteraId, Long facturaId);
    Optional<Factura> getFacturaById(Long facturaid);
}
