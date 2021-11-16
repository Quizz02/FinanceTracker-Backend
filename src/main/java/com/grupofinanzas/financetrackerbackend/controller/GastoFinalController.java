package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.service.GastoFinalService;
import org.modelmapper.ModelMapper;
import com.grupofinanzas.financetrackerbackend.resource.gastofinal.SaveGastoFinalResource;
import com.grupofinanzas.financetrackerbackend.resource.gastofinal.GastoFinalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GastoFinalController {
    @Autowired
    private GastoFinalService gastoFinalService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{facturaid}/gastos")
    public List<GastoFinalResource> getAllGFbyFacturaID(@PathVariable Long facturaid){
        return gastoFinalService.getallgastobyFacturaId(facturaid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{letraid}/gastos")
    public List<GastoFinalResource> getAllGFbyLetraID(@PathVariable Long letraid){
        return gastoFinalService.getallgastobyLetraId(letraid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{reciboid}/gastos")
    public List<GastoFinalResource> getAllGFbyReciboID(@PathVariable Long reciboid){
        return gastoFinalService.getallgastobyReciboId(reciboid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{facturaid}/gastos/{gastofinalid}")
    public GastoFinalResource getGFbyIDandFacturaID(@PathVariable Long facturaid, @PathVariable Long gastofinalid){
        Optional<GastoFinal> gastoFinal= gastoFinalService.getgfbyidandfacturaid(facturaid,gastofinalid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @GetMapping("/{letraid}/gastos/{gastofinalid}")
    public GastoFinalResource getGFbyIDandLetraID(@PathVariable Long letraid, @PathVariable Long gastofinalid){
        Optional<GastoFinal> gastoFinal= gastoFinalService.getgfbyidandletraid(letraid,gastofinalid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @GetMapping("/{reciboid}/gastos/{gastofinalid}")
    public GastoFinalResource getGFbyIDandReciboID(@PathVariable Long reciboid, @PathVariable Long gastofinalid){
        Optional<GastoFinal> gastoFinal= gastoFinalService.getgfbyidandreciboid(reciboid,gastofinalid);
        return gastoFinal.map(this::convertToResource).orElse(null);
    }

    @PostMapping("/{facturaid}/gastos")
    public GastoFinalResource createGFByFacturaID(@PathVariable Long facturaid,@RequestBody SaveGastoFinalResource gastoFinalResource){
        GastoFinal gastoFinal = convertToEntity(gastoFinalResource);
        return convertToResource(gastoFinalService.creategfbyfacturaid(facturaid,gastoFinal));
    }

    @PostMapping("/{letraid}/gastos")
    public GastoFinalResource createGFByLetraID(@PathVariable Long letraid,@RequestBody SaveGastoFinalResource gastoFinalResource){
        GastoFinal gastoFinal = convertToEntity(gastoFinalResource);
        return convertToResource(gastoFinalService.creategfbyletraid(letraid,gastoFinal));
    }

    @PostMapping("/{reciboid}/gastos")
    public GastoFinalResource createGFByReciboID(@PathVariable Long reciboid,@RequestBody SaveGastoFinalResource gastoFinalResource){
        GastoFinal gastoFinal = convertToEntity(gastoFinalResource);
        return convertToResource(gastoFinalService.creategfbyreciboid(reciboid,gastoFinal));
    }

    @DeleteMapping("/{facturaid}/gastos/{gastofinalid}")
    public ResponseEntity<?> deleteGFbyFacturaid(@PathVariable Long facturaid,@PathVariable Long gastofinalid){
        return  gastoFinalService.deletebyFacturaId(facturaid,gastofinalid);
    }

    @DeleteMapping("/{letraid}/gastos/{gastofinalid}")
    public ResponseEntity<?> deleteGFbyLetraid(@PathVariable Long letraid,@PathVariable Long gastofinalid){
        return  gastoFinalService.deletebyLetraId(letraid,gastofinalid);
    }

    @DeleteMapping("/{reciboid}/gastos/{gastofinalid}")
    public ResponseEntity<?> deleteGFbyReciboid(@PathVariable Long reciboid,@PathVariable Long gastofinalid){
        return  gastoFinalService.deletebyReciboId(reciboid,gastofinalid);
    }


    private GastoFinal convertToEntity(SaveGastoFinalResource resource){
        return mapper.map(resource, GastoFinal.class);
    }
    private GastoFinalResource convertToResource(GastoFinal entity){
        return mapper.map(entity, GastoFinalResource.class);
    }
}
