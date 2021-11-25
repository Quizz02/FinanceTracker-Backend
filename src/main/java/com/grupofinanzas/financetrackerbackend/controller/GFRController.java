package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.GFR;
import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.repository.GFRRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.GFRService;
import com.grupofinanzas.financetrackerbackend.domain.service.GILService;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.GILResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.SaveGILResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosrecibos.GFRResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosrecibos.SaveGFRResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GFRController {
    @Autowired
    private GFRService gifService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/{facturaid}/gastofinalesR")
    public GFRResource createGFbyFacturaId(@PathVariable Long facturaid, @RequestBody SaveGFRResource resource){
        GFR gastoFinal = convertToEntity(resource);
        return convertToResource(gifService.creategfbyfacturaid(facturaid,gastoFinal));
    }

    @GetMapping("/{facturaid}/gastofinalesR")
    public List<GFRResource> getAllgastosbyfacturaId(@PathVariable Long facturaid){
        return gifService.getallgastobyFacturaId(facturaid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{facturaid}/gastofinalesR/{gastofinalid}")
    public GFRResource getGFByIdAndFacturaId(@PathVariable Long facturaid,@PathVariable Long gastofinalid){
        Optional<GFR> gastoFinal = gifService.getgfbyidandfacturaid(facturaid,facturaid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @DeleteMapping("/{userid}/gastofinalesR/{carteraid}")
    public ResponseEntity<?> deleteGF(@PathVariable Long userid, @PathVariable Long carteraid){
        return gifService.deletebyFacturaId(userid,carteraid);
    }

    @GetMapping("/gastofinalesR/{id}")
    public GFRResource getUserById(@PathVariable Long id){
        Optional<GFR> gastoFinal = gifService.getGFbyId(id);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }


    private GFR convertToEntity(SaveGFRResource resource){
        return mapper.map(resource, GFR.class);
    }

    private GFRResource convertToResource(GFR entity){
        return mapper.map(entity, GFRResource.class);
    }
}
