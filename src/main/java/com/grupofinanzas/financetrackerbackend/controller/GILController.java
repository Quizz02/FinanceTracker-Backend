package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import com.grupofinanzas.financetrackerbackend.domain.service.GIFService;
import com.grupofinanzas.financetrackerbackend.domain.service.GILService;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.GastoInicialResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.SaveGastoInicialResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.GILResource;
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
@CrossOrigin
public class GILController {
    @Autowired
    private GILService gifService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/{facturaid}/gastosincialesL")
    public GILResource createGFbyFacturaId(@PathVariable Long facturaid, @RequestBody SaveGILResource resource){
        GIL gastoFinal = convertToEntity(resource);
        return convertToResource(gifService.creategfbyfacturaid(facturaid,gastoFinal));
    }

    @GetMapping("/{facturaid}/gastosincialesL")
    public List<GILResource> getAllgastosbyfacturaId(@PathVariable Long facturaid){
        return gifService.getallgastobyFacturaId(facturaid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{facturaid}/gastosincialesL/{gastofinalid}")
    public GILResource getGFByIdAndFacturaId(@PathVariable Long facturaid,@PathVariable Long gastofinalid){
        Optional<GIL> gastoFinal = gifService.getgfbyidandfacturaid(facturaid,facturaid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @DeleteMapping("/{userid}/gastosincialesL/{carteraid}")
    public ResponseEntity<?> deleteGF(@PathVariable Long userid, @PathVariable Long carteraid){
        return gifService.deletebyFacturaId(userid,carteraid);
    }

    @GetMapping("/gastosincialesL/{id}")
    public GILResource getUserById(@PathVariable Long id){
        Optional<GIL> gastoFinal = gifService.getGFbyId(id);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }



    private GIL convertToEntity(SaveGILResource resource){
        return mapper.map(resource, GIL.class);
    }

    private GILResource convertToResource(GIL entity){
        return mapper.map(entity, GILResource.class);
    }
}
