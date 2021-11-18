package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.PlazoTasa;
import com.grupofinanzas.financetrackerbackend.domain.service.PlazoTasaService;
import com.grupofinanzas.financetrackerbackend.resource.plazotasa.PlazoTasaResource;
import com.grupofinanzas.financetrackerbackend.resource.plazotasa.SavePlazoTasaResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlazoTasaController {
    @Autowired
    private PlazoTasaService plazoTasaService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/ptasas")
    public PlazoTasaResource createPlazoTasa(@Valid @RequestBody SavePlazoTasaResource resource) {
        PlazoTasa plazoTasa = converToEntity(resource);
        return converToResource(plazoTasaService.createPlazo(plazoTasa));
    }

    @GetMapping("/ptasas/{id}")
    public PlazoTasaResource gettPlazoById(@PathVariable Long id) {
        Optional<PlazoTasa> plazoTasa = plazoTasaService.getPlazoById(id);
        return plazoTasa.map(this::converToResource).orElse(null);
    }

    @GetMapping("/ptasas")
    public List<PlazoTasaResource> getAllPTasa() {
        return plazoTasaService.getAllPlazos()
                .stream()
                .map(
                        plazoTasa -> mapper.map(plazoTasa, PlazoTasaResource.class)
                ).collect(Collectors.toList());
    }

    @DeleteMapping("/ptasas/{id}")
    public ResponseEntity<?> deletePlazo(@PathVariable Long id) {
        return plazoTasaService.deletePlazo(id);
    }


    private PlazoTasa converToEntity(SavePlazoTasaResource resource) {
        return mapper.map(resource, PlazoTasa.class);
    }

    private PlazoTasaResource converToResource(PlazoTasa entity) {
        return mapper.map(entity, PlazoTasaResource.class);
    }
}

