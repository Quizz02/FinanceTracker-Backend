package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import com.grupofinanzas.financetrackerbackend.domain.service.GFFService;
import com.grupofinanzas.financetrackerbackend.domain.service.GIFService;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.GastoFinalResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.GastoInicialResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.SaveGastoFinalResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.SaveGastoInicialResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GastoInicialController {
    @Autowired
    private GIFService gifService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/{facturaid}/gastosinciales")
    public GastoInicialResource createGFbyFacturaId(@PathVariable Long facturaid, @RequestBody SaveGastoInicialResource resource){
        GastoInicial gastoFinal = convertToEntity(resource);
        return convertToResource(gifService.creategfbyfacturaid(facturaid,gastoFinal));
    }

    @GetMapping("/{facturaid}/gastosinciales")
    public List<GastoInicialResource> getAllgastosbyfacturaId(@PathVariable Long facturaid){
        return gifService.getallgastobyFacturaId(facturaid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{facturaid}/gastosinciales/{gastofinalid}")
    public GastoInicialResource getGFByIdAndFacturaId(@PathVariable Long facturaid,@PathVariable Long gastofinalid){
        Optional<GastoInicial> gastoFinal = gifService.getgfbyidandfacturaid(facturaid,facturaid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @DeleteMapping("/{userid}/gastosinciales/{carteraid}")
    public ResponseEntity<?> deleteGF(@PathVariable Long userid, @PathVariable Long carteraid){
        return gifService.deletebyFacturaId(userid,carteraid);
    }

    @GetMapping("/gastosinciales/{id}")
    public GastoInicialResource getUserById(@PathVariable Long id){
        Optional<GastoInicial> gastoFinal = gifService.getGFbyId(id);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }


    @DeleteMapping("/{facturaid}/gastosinciales/{gastofinalid}")
    public ResponseEntity<?> deleteGastoFinal(@PathVariable Long facturaid, @PathVariable Long gastofinalid){
        return gifService.deletebyFacturaId(facturaid,gastofinalid);
    }

    private GastoInicial convertToEntity(SaveGastoInicialResource resource){
        return mapper.map(resource, GastoInicial.class);
    }

    private GastoInicialResource convertToResource(GastoInicial entity){
        return mapper.map(entity, GastoInicialResource.class);
    }
}
