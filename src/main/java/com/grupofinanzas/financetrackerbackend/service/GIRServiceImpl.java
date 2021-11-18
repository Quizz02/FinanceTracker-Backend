package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.model.GIR;
import com.grupofinanzas.financetrackerbackend.domain.repository.GILRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.GIRRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.LetraRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.ReciboRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.GIRService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GIRServiceImpl implements GIRService {
    @Autowired
    private GIRRepository gifRepository;
    @Autowired
    private ReciboRepository facturaRepository;

    @Override
    public GIR creategfbyfacturaid(Long facturaId, GIR gastoFinal) {
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
    public List<GIR> getallgastobyFacturaId(Long facturaid) {
        return gifRepository.findAllByReciboHonorarioId(facturaid);

    }

    @Override
    public Optional<GIR> getgfbyidandfacturaid(Long facturaId, Long gastofinalId) {
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
    public Optional<GIR> getGFbyId(Long gastofinalid) {
        return gifRepository.findById(gastofinalid);
    }
}
