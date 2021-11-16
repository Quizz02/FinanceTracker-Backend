package com.grupofinanzas.financetrackerbackend.service;


import com.grupofinanzas.financetrackerbackend.domain.model.PlazoTasa;
import com.grupofinanzas.financetrackerbackend.domain.repository.PlazoTasaRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.PlazoTasaService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlazoTasaServiceImpl implements PlazoTasaService {

    @Autowired
    private PlazoTasaRepository plazoTasaRepository;

    public PlazoTasa createPlazoTasa(PlazoTasa plazoTasa){
        return plazoTasaRepository.save(plazoTasa);
    }


    @Override
    public ArrayList<PlazoTasa> getAllPlazos() {
        return (ArrayList<PlazoTasa>)
                plazoTasaRepository.findAll();
    }

    @Override
    public PlazoTasa createPlazo(PlazoTasa plazoTasa) {
        return plazoTasaRepository.save(plazoTasa);
    }

    @Override
    public ResponseEntity<?> deletePlazo(Long plazoTasa) {
        PlazoTasa plazoTasa1= plazoTasaRepository.findById(plazoTasa)
                .orElseThrow(()-> new ResourceNotFoundException("PlazoTasa","Id",plazoTasa));
        plazoTasaRepository.delete(plazoTasa1);
        return ResponseEntity.ok().build();
    }

    @Override
    public Optional<PlazoTasa> getPlazoById(Long plazoTasa) {
        return plazoTasaRepository.findById(plazoTasa);
    }
}
