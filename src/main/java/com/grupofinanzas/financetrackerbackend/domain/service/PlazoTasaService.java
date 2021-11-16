package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.PlazoTasa;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PlazoTasaService {
    List<PlazoTasa> getAllPlazos();
    PlazoTasa createPlazo(PlazoTasa plazoTasa);
    ResponseEntity<?> deletePlazo(Long plazoTasa);
    Optional<PlazoTasa> getPlazoById(Long plazoTasa);

}
