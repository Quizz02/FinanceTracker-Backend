package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import com.grupofinanzas.financetrackerbackend.domain.repository.FacturaRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.GFFRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.GIFRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.GIFService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GIFServiceImpl implements GIFService {
    @Autowired
    private GIFRepository gifRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public GastoInicial creategfbyfacturaid(Long facturaId, GastoInicial gastoFinal) {
        return facturaRepository.findById(facturaId).map(
                factura -> {
                    gastoFinal.setFactura(factura);
                    gastoFinal.setMonto(gastoFinal.getMonto());
                    gastoFinal.setMotivo(gastoFinal.getMotivo());
                    return gifRepository.save(gastoFinal);
                }
        ).orElseThrow(()-> new ResourceNotFoundException(
                "factura","Id",facturaId
        ));
    }

    @Override
    public List<GastoInicial> getallgastobyFacturaId(Long facturaid) {
        return gifRepository.findAllByFacturaId(facturaid);

    }

    @Override
    public Optional<GastoInicial> getgfbyidandfacturaid(Long facturaId, Long gastofinalId) {
        return gifRepository.findGastoFinalByFacturaAndId(facturaId,gastofinalId);
    }

    @Override
    public ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId) {
        if(facturaRepository.existsById(facturaId))
            throw new ResourceNotFoundException(
                    "Factura","Id",facturaId
            );

        return gifRepository.findById(gastofinalId).map(
                gastofinal ->{
                    gifRepository.delete(gastofinal);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("GastoInicial","Id",gastofinalId));
    }

    @Override
    public Optional<GastoInicial> getGFbyId(Long gastofinalid) {
        return gifRepository.findById(gastofinalid);
    }
}
