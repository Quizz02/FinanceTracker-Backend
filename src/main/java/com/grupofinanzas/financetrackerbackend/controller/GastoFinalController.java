package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.service.GFFService;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.GastoFinalResource;
import com.grupofinanzas.financetrackerbackend.resource.gastosfacturas.SaveGastoFinalResource;
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
public class GastoFinalController {
    @Autowired
    private GFFService gffService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/{facturaid}/gastosfinales")
    public GastoFinalResource createGFbyFacturaId(@PathVariable Long facturaid, @RequestBody SaveGastoFinalResource resource){
        GastoFinal gastoFinal = convertToEntity(resource);
        return convertToResource(gffService.creategfbyfacturaid(facturaid,gastoFinal));
    }

    @GetMapping("/{facturaid}/gastosfinales")
    public List<GastoFinalResource> getAllgastosbyfacturaId(@PathVariable Long facturaid){
        return gffService.getallgastobyFacturaId(facturaid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{facturaid}/gastosfinales/{gastofinalid}")
    public GastoFinalResource getGFByIdAndFacturaId(@PathVariable Long facturaid,@PathVariable Long gastofinalid){
        Optional<GastoFinal>  gastoFinal = gffService.getgfbyidandfacturaid(facturaid,facturaid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @DeleteMapping("/{userid}/gastofinal/{carteraid}")
    public ResponseEntity<?> deleteGF(@PathVariable Long userid, @PathVariable Long carteraid){
        return gffService.deletebyFacturaId(userid,carteraid);
    }

    @GetMapping("/gastofinal/{id}")
    public GastoFinalResource getUserById(@PathVariable Long id){
        Optional<GastoFinal> gastoFinal = gffService.getGFbyId(id);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }


    @DeleteMapping("/{facturaid}/gastosfinales/{gastofinalid}")
    public ResponseEntity<?> deleteGastoFinal(@PathVariable Long facturaid, @PathVariable Long gastofinalid){
        return gffService.deletebyFacturaId(facturaid,gastofinalid);
    }

    private GastoFinal convertToEntity(SaveGastoFinalResource resource){
        return mapper.map(resource, GastoFinal.class);
    }

    private GastoFinalResource convertToResource(GastoFinal entity){
        return mapper.map(entity, GastoFinalResource.class);
    }

}
