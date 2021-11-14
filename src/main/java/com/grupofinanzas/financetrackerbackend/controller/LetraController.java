package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.Letra;
import com.grupofinanzas.financetrackerbackend.domain.service.LetraService;
import com.grupofinanzas.financetrackerbackend.resource.letra.LetraResource;
import com.grupofinanzas.financetrackerbackend.resource.letra.SaveLetraResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LetraController {
    @Autowired
    private LetraService letraService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{carteraid}/letras")
    public List<LetraResource> getAllLetrasByCarteraId(@PathVariable Long carteraid){
        return letraService.getAllLetrasByCarteraId(carteraid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{carteraid}/letras/{letraid}")
    public LetraResource getLetraByIdAndCarteraId(@PathVariable Long carteraid, @PathVariable Long letraid){
        Optional<Letra> letra = letraService.getLetraByIdAndCarteraId(carteraid,letraid);
        return letra.map(this::convertToResource).orElse(null);
    }

    @PostMapping("/{carteraid}/letras")
    public LetraResource createLetra(@PathVariable Long carteraid, @RequestBody SaveLetraResource letraResource){
        Letra letra = convertToEntity(letraResource);
        return convertToResource(letraService.createLetraByCarteraId(carteraid,letra));
    }

    @DeleteMapping("/{carteraid}/letras/{letraid}")
    public ResponseEntity<?> deleteLetra(@PathVariable Long carteraid, @PathVariable Long letraid){
        return letraService.deleteLetra(carteraid, letraid);
    }

    @PutMapping("/{carteraid}/letras/{letraid}")
    public LetraResource updateLetra(@PathVariable Long carteraid,@PathVariable Long letraid,@RequestBody SaveLetraResource letraResource){
        Letra letra = convertToEntity(letraResource);
        return convertToResource(letraService.updateLetra(carteraid,letraid,letra));
    }

    private Letra convertToEntity(SaveLetraResource resource){
        return mapper.map(resource, Letra.class);
    }

    private LetraResource convertToResource(Letra entity){
        return mapper.map(entity, LetraResource.class);
    }

}
