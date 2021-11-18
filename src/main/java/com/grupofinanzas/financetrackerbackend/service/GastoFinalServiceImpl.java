package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.repository.FacturaRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.GFFRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.GFFService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoFinalServiceImpl implements GFFService {
    @Autowired
    private GFFRepository gffRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public GastoFinal creategfbyfacturaid(Long facturaId, GastoFinal gastoFinal) {
        return facturaRepository.findById(facturaId).map(
                factura -> {
                    gastoFinal.setFactura(factura);
                    gastoFinal.setMonto(gastoFinal.getMonto());
                    gastoFinal.setMotivo(gastoFinal.getMotivo());
                    return gffRepository.save(gastoFinal);
                }
        ).orElseThrow(()-> new ResourceNotFoundException(
                "factura","Id",facturaId
        ));
    }

    @Override
    public List<GastoFinal> getallgastobyFacturaId(Long facturaid) {
        return gffRepository.findAllByFacturaId(facturaid);

    }

    @Override
    public Optional<GastoFinal> getgfbyidandfacturaid(Long facturaId, Long gastofinalId) {
        return gffRepository.findGastoFinalByFacturaAndId(facturaId,gastofinalId);
    }

    @Override
    public ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId) {
        if(facturaRepository.existsById(facturaId))
            throw new ResourceNotFoundException(
                    "Factura","Id",facturaId
            );

        return gffRepository.findById(gastofinalId).map(
                gastofinal ->{
                    gffRepository.delete(gastofinal);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("gastofinal","Id",gastofinalId));
    }

    @Override
    public Optional<GastoFinal> getGFbyId(Long gastofinalid) {
        return gffRepository.findById(gastofinalid);
    }
}
