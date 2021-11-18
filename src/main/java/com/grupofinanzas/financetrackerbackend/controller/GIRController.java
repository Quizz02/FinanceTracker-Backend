package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.model.GIR;
import com.grupofinanzas.financetrackerbackend.domain.service.GILService;
import com.grupofinanzas.financetrackerbackend.domain.service.GIRService;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.GILResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosletras.SaveGILResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosrecibos.GIRResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosrecibos.SaveGIRResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GIRController {
    @Autowired
    private GIRService gifService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/{facturaid}/gastosincialesR")
    public GIRResource createGFbyFacturaId(@PathVariable Long facturaid, @RequestBody SaveGIRResource resource){
        GIR gastoFinal = convertToEntity(resource);
        return convertToResource(gifService.creategfbyfacturaid(facturaid,gastoFinal));
    }

    @GetMapping("/{facturaid}/gastosincialesR")
    public List<GIRResource> getAllgastosbyfacturaId(@PathVariable Long facturaid){
        return gifService.getallgastobyFacturaId(facturaid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{facturaid}/gastosincialesR/{gastofinalid}")
    public GIRResource getGFByIdAndFacturaId(@PathVariable Long facturaid,@PathVariable Long gastofinalid){
        Optional<GIR> gastoFinal = gifService.getgfbyidandfacturaid(facturaid,facturaid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @DeleteMapping("/{userid}/gastosincialesR/{carteraid}")
    public ResponseEntity<?> deleteGF(@PathVariable Long userid, @PathVariable Long carteraid){
        return gifService.deletebyFacturaId(userid,carteraid);
    }

    @GetMapping("/gastosincialesR/{id}")
    public GIRResource getUserById(@PathVariable Long id){
        Optional<GIR> gastoFinal = gifService.getGFbyId(id);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }



    private GIR convertToEntity(SaveGIRResource resource){
    return mapper.map(resource, GIR.class);
    }

    private GIRResource convertToResource(GIR entity){
        return mapper.map(entity, GIRResource.class);
    }

}
