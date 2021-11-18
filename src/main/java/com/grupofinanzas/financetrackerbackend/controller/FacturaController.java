package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.service.FacturaService;
import com.grupofinanzas.financetrackerbackend.resource.factura.FacturaResource;
import com.grupofinanzas.financetrackerbackend.resource.factura.SaveFacturaResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{carteraid}/facturas")
    public List<FacturaResource> getAllFacturasByCarteraId(@PathVariable Long carteraid){
        return facturaService.getAllFacturasByCarteraId(carteraid).stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/{carteraid}/facturas/{facturaid}")
    public FacturaResource getFacturaByIdAndCarteraId(@PathVariable Long carteraid, @PathVariable Long facturaid){
        Optional<Factura> factura = facturaService.getFacturaByIdAndCarteraId(carteraid,facturaid);
        return factura.map(this::convertToResource).orElse(null);
    }

    @PostMapping("/{carteraid}/facturas/{plazotasaid}")
    public FacturaResource createFactura(@PathVariable Long carteraid, @PathVariable Long plazotasaid, @RequestBody SaveFacturaResource resource){
        Factura factura = convertToEntity(resource);
        return convertToResource(facturaService.createFacturaByCarteraId(carteraid,plazotasaid,factura));
    }

    @DeleteMapping("/{carteraid}/facturas/{facturaid}")
    public ResponseEntity<?> deleteFactura(@PathVariable Long carteraid, @PathVariable Long facturaid){
        return facturaService.deleteFactura(carteraid, facturaid);
    }

    @PutMapping("/{carteraid}/facturas/{facturaid}")
    public FacturaResource updateFactura(@PathVariable Long carteraid,@PathVariable Long facturaid,@RequestBody SaveFacturaResource facturaResource){
        Factura factura = convertToEntity(facturaResource);
        return convertToResource(facturaService.updateFactura(carteraid,facturaid,factura));
    }

    @GetMapping("/facturas/{id}")
    public FacturaResource getFacturaById(@PathVariable Long id){
        Optional<Factura> factura=facturaService.getFacturaById(id);
        return  factura.map(this::convertToResource).orElse(null);
    }

    private Factura convertToEntity(SaveFacturaResource resource){
        return mapper.map(resource, Factura.class);
    }

    private FacturaResource convertToResource(Factura entity){
        return mapper.map(entity, FacturaResource.class);
    }

}
