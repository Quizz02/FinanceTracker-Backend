package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.GFLFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GIL;
import com.grupofinanzas.financetrackerbackend.domain.repository.GFLRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.GILRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.LetraRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.GFLService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GFLServiceImpl implements GFLService {
    @Autowired
    private GFLRepository gifRepository;
    @Autowired
    private LetraRepository facturaRepository;

    @Override
    public GFLFinal creategfbyfacturaid(Long facturaId, GFLFinal gastoFinal) {
        return facturaRepository.findById(facturaId).map(
                factura -> {
                    gastoFinal.setLetra(factura);
                    gastoFinal.setMonto(gastoFinal.getMonto());
                    gastoFinal.setMotivo(gastoFinal.getMotivo());
                    return gifRepository.save(gastoFinal);
                }
        ).orElseThrow(()-> new ResourceNotFoundException(
                "Letra","Id",facturaId
        ));
    }

    @Override
    public List<GFLFinal> getallgastobyFacturaId(Long facturaid) {
        return gifRepository.findAllByLetraId(facturaid);

    }

    @Override
    public Optional<GFLFinal> getgfbyidandfacturaid(Long facturaId, Long gastofinalId) {
        return gifRepository.findGastoFinalByLetraAndId(facturaId,gastofinalId);
    }

    @Override
    public ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId) {
        if(facturaRepository.existsById(facturaId))
            throw new ResourceNotFoundException(
                    "Letra","Id",facturaId
            );

        return gifRepository.findById(gastofinalId).map(
                gastofinal ->{
                    gifRepository.delete(gastofinal);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("GastoFinalLetra","Id",gastofinalId));
    }

    @Override
    public Optional<GFLFinal> getGFbyId(Long gastofinalid) {
        return gifRepository.findById(gastofinalid);
    }
}
