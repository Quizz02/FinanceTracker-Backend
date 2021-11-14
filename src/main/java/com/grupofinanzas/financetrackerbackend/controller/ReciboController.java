package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.ReciboHonorario;
import com.grupofinanzas.financetrackerbackend.domain.service.ReciboService;
import com.grupofinanzas.financetrackerbackend.resource.recibo.ReciboResource;
import com.grupofinanzas.financetrackerbackend.resource.recibo.SaveReciboResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ReciboController {
    @Autowired
    private ReciboService reciboService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{carteraid}/recibos")
    public List<ReciboResource> getAllRecibosByCarteraId(@PathVariable Long carteraid){
        return reciboService.getAllRecibosByCarteraId(carteraid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{carteraid}/recibos/{reciboid}")
    public ReciboResource getReciboByIdAndCarteraId(@PathVariable Long carteraid, @PathVariable Long reciboid){
        Optional<ReciboHonorario> reciboHonorario = reciboService.getReciboByIdAndCarteraId(carteraid, reciboid);
        return reciboHonorario.map(this::convertToResource).orElse(null);
    }

    @PostMapping("/{carteraid}/recibos")
    public ReciboResource createRecibo(@PathVariable Long carteraid, @RequestBody SaveReciboResource reciboResource){
        ReciboHonorario reciboHonorario = convertToEntity(reciboResource);
        return convertToResource(reciboService.createReciboByCarteraId(carteraid,reciboHonorario));
    }

    @DeleteMapping("/{carteraid}/recibos/{reciboid}")
    public ResponseEntity<?> deleteRecibo(@PathVariable Long carteraid, @PathVariable Long reciboid){
        return reciboService.deleteRecibo(carteraid, reciboid);
    }

    @PutMapping("/{carteraid}/recibos/{reciboid}")
    public ReciboResource updateRecibo(@PathVariable Long carteraid,@PathVariable Long reciboid,@RequestBody SaveReciboResource reciboResource){
        ReciboHonorario reciboHonorario = convertToEntity(reciboResource);
        return convertToResource(reciboService.updateRecibo(carteraid,reciboid,reciboHonorario));
    }

    private ReciboHonorario convertToEntity(SaveReciboResource resource){ return mapper.map(resource, ReciboHonorario.class);}

    private ReciboResource convertToResource(ReciboHonorario entity){ return mapper.map(entity, ReciboResource.class);}

}