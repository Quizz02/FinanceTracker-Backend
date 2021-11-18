package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GFR;
import com.grupofinanzas.financetrackerbackend.domain.model.GIR;
import com.grupofinanzas.financetrackerbackend.domain.repository.GFRRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.GIRRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.ReciboRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.GFRService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GFRServiceImpl implements GFRService {
    @Autowired
    private GFRRepository gifRepository;
    @Autowired
    private ReciboRepository facturaRepository;

    @Override
    public GFR creategfbyfacturaid(Long facturaId, GFR gastoFinal) {
        return facturaRepository.findById(facturaId).map(
                factura -> {
                    gastoFinal.setReciboHonorario(factura);
                    gastoFinal.setMonto(gastoFinal.getMonto());
                    gastoFinal.setMotivo(gastoFinal.getMotivo());
                    return gifRepository.save(gastoFinal);
                }
        ).orElseThrow(()-> new ResourceNotFoundException(
                "Recibo","Id",facturaId
        ));
    }

    @Override
    public List<GFR> getallgastobyFacturaId(Long facturaid) {
        return gifRepository.findAllByReciboHonorarioId(facturaid);

    }

    @Override
    public Optional<GFR> getgfbyidandfacturaid(Long facturaId, Long gastofinalId) {
        return gifRepository.findGastoFinalByReciboHonorarioAndId(facturaId,gastofinalId);
    }

    @Override
    public ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId) {
        if(facturaRepository.existsById(facturaId))
            throw new ResourceNotFoundException(
                    "Recibo","Id",facturaId
            );

        return gifRepository.findById(gastofinalId).map(
                gastofinal ->{
                    gifRepository.delete(gastofinal);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("GastoInicialLetra","Id",gastofinalId));
    }

    @Override
    public Optional<GFR> getGFbyId(Long gastofinalid) {
        return gifRepository.findById(gastofinalid);
    }
}
