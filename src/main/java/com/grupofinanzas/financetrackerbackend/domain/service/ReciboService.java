package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.ReciboHonorario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ReciboService {
    ReciboHonorario createReciboByCarteraId(Long carteraId, ReciboHonorario reciboHonorario);
    List<ReciboHonorario> getAllRecibosByCarteraId(Long carteraId);
    Optional<ReciboHonorario> getReciboByIdAndCarteraId(Long carteraId, Long reciboId);
    ReciboHonorario updateRecibo(Long carteraId, Long reciboId, ReciboHonorario reciboHonorario);
    ResponseEntity<?> deleteRecibo(Long carteraId, Long reciboId);
}
