package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.Letra;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface LetraService {
    Letra createLetraByCarteraId(Long carteraId, Letra letra);
    List<Letra> getAllLetrasByCarteraId(Long carteraId);
    Optional<Letra> getLetraByIdAndCarteraId(Long carteraId, Long letraId);
    Letra updateLetra(Long carteraId, Long letraId, Letra letra);
    ResponseEntity<?> deleteLetra(Long carteraId, Long letraId);
}
