package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.GFLFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.service.GFLService;
import com.grupofinanzas.financetrackerbackend.domain.service.GILService;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.GFLResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.GILResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.SaveGFLResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.SaveGILResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GFLController {
    @Autowired
    private GFLService gifService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/{facturaid}/gastosfinalesL")
    public GFLResource createGFbyFacturaId(@PathVariable Long facturaid, @RequestBody SaveGFLResource resource){
        GFLFinal gastoFinal = convertToEntity(resource);
        return convertToResource(gifService.creategfbyfacturaid(facturaid,gastoFinal));
    }

    @GetMapping("/{facturaid}/gastosfinalesL")
    public List<GFLResource> getAllgastosbyfacturaId(@PathVariable Long facturaid){
        return gifService.getallgastobyFacturaId(facturaid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{facturaid}/gastosfinalesL/{gastofinalid}")
    public GFLResource getGFByIdAndFacturaId(@PathVariable Long facturaid,@PathVariable Long gastofinalid){
        Optional<GFLFinal> gastoFinal = gifService.getgfbyidandfacturaid(facturaid,facturaid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @DeleteMapping("/{userid}/gastosfinalesL/{carteraid}")
    public ResponseEntity<?> deleteGF(@PathVariable Long userid, @PathVariable Long carteraid){
        return gifService.deletebyFacturaId(userid,carteraid);
    }

    @GetMapping("/gastosfinalesL/{id}")
    public GFLResource getUserById(@PathVariable Long id){
        Optional<GFLFinal> gastoFinal = gifService.getGFbyId(id);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }


    @DeleteMapping("/{facturaid}/gastosfinalesL/{gastofinalid}")
    public ResponseEntity<?> deleteGastoFinal(@PathVariable Long facturaid, @PathVariable Long gastofinalid){
        return gifService.deletebyFacturaId(facturaid,gastofinalid);
    }

    private GFLFinal convertToEntity(SaveGFLResource resource){
        return mapper.map(resource, GFLFinal.class);
    }

    private GFLResource convertToResource(GFLFinal entity){
        return mapper.map(entity, GFLResource.class);
    }
}
