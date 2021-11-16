package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.PlazoTasa;
import com.grupofinanzas.financetrackerbackend.domain.service.PlazoTasaService;
import com.grupofinanzas.financetrackerbackend.resource.plazotasa.PlazoTasaResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PlazoTasaController {
    @Autowired
    private PlazoTasaService plazoTasaService;

    @Autowired
    private ModelMapper mapper;

}
