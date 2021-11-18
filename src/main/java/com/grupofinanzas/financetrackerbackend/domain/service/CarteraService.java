package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Cartera;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CarteraService {
    Cartera createCarteraByUserId(Long userId, Cartera cartera);
    Optional<Cartera> getCarteraByIdAndByUserId(Long userId, Long carteraId);
    Cartera updateCartera(Long userId,Long carteraId,Cartera cartera);
    ResponseEntity<?> deleteCartera(Long userId, Long carteraId);
    List<Cartera> getAllCarterasByUserId(Long userId);
}
