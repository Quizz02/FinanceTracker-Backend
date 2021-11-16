package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.repository.FacturaRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.GastoFinalRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.LetraRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.ReciboRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.GastoFinalService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoFinalServiceImpl implements GastoFinalService {
    @Autowired
    private GastoFinalRepository gastoFinalRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ReciboRepository reciboRepository;
    @Autowired
    private LetraRepository letraRepository;
    @Override
    public GastoFinal creategfbyletraid(Long letraId, GastoFinal gastoFinal) {
        return letraRepository.findById(letraId).map(
                letra -> {
                    gastoFinal.setLetra(letra);
                    gastoFinal.setMonto(gastoFinal.getMonto());
                    gastoFinal.setMotivo(gastoFinal.getMotivo());
                    return gastoFinalRepository.save(gastoFinal);
                }
        ).orElseThrow(()-> new ResourceNotFoundException(
                "Letra","Id",letraId
        ));
    }

    @Override
    public GastoFinal creategfbyreciboid(Long reciboId, GastoFinal gastoFinal) {
        return reciboRepository.findById(reciboId).map(
                reciboHonorario -> {

                    gastoFinal.setRecibo(reciboHonorario);
                    gastoFinal.setMonto(gastoFinal.getMonto());
                    gastoFinal.setMotivo(gastoFinal.getMotivo());
                    return gastoFinalRepository.save(gastoFinal);
                }
        ).orElseThrow(()-> new ResourceNotFoundException(
                "reciboHonorario","Id",reciboId
        ));
    }

    @Override
    public GastoFinal creategfbyfacturaid(Long facturaId, GastoFinal gastoFinal) {
        return facturaRepository.findById(facturaId).map(
                factura -> {
                    gastoFinal.setFactura(factura);
                    gastoFinal.setMonto(gastoFinal.getMonto());
                    gastoFinal.setMotivo(gastoFinal.getMotivo());
                    return gastoFinalRepository.save(gastoFinal);
                }
        ).orElseThrow(()-> new ResourceNotFoundException(
                "factura","Id",facturaId
        ));
    }

    @Override
    public List<GastoFinal> getallgastobyFacturaId(Long facturaid) {
        return gastoFinalRepository.findAllByFacturaId(facturaid);
    }

    @Override
    public List<GastoFinal> getallgastobyLetraId(Long letraid) {
        return gastoFinalRepository.findAllByLetraId(letraid);
    }

    @Override
    public List<GastoFinal> getallgastobyReciboId(Long reciboid) {
        return gastoFinalRepository.findAllByReciboId(reciboid);
    }

    @Override
    public Optional<GastoFinal> getgfbyidandfacturaid(Long facturaId, Long gastofinalId) {
        return gastoFinalRepository.findGastoFinalByFacturaAndId(facturaId,gastofinalId);
    }

    @Override
    public Optional<GastoFinal> getgfbyidandletraid(Long letraId, Long gastofinalId) {
        return gastoFinalRepository.findGastoFinalByLetraAndId(letraId,gastofinalId);
    }

    @Override
    public Optional<GastoFinal> getgfbyidandreciboid(Long reciboId, Long gastofinalId) {
        return gastoFinalRepository.findGastoFinalByReciboAndId(reciboId,gastofinalId);
    }

    @Override
    public ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId){
        if(facturaRepository.existsById(facturaId))
            throw new ResourceNotFoundException(
                    "Factura","Id",facturaId
            );

        return gastoFinalRepository.findById(gastofinalId).map(
                gastofinal ->{
                    gastoFinalRepository.delete(gastofinal);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("gastofinal","Id",gastofinalId));
    }

    @Override
    public ResponseEntity<?> deletebyLetraId(Long letraId, Long gastofinalId) {
        if(letraRepository.existsById(letraId))
            throw new ResourceNotFoundException(
                    "Letra","Id",letraId
            );

        return gastoFinalRepository.findById(gastofinalId).map(
                gastofinal ->{
                    gastoFinalRepository.delete(gastofinal);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("gastofinal","Id",gastofinalId));
    }

    @Override
    public ResponseEntity<?> deletebyReciboId(Long reciboId, Long gastofinalId) {
        if(reciboRepository.existsById(reciboId))
            throw new ResourceNotFoundException(
                    "Recibo","Id",reciboId
            );

        return gastoFinalRepository.findById(gastofinalId).map(
                gastofinal ->{
                    gastoFinalRepository.delete(gastofinal);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException("gastofinal","Id",gastofinalId));
    }
}
