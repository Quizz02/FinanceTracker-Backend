package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Letra;
import com.grupofinanzas.financetrackerbackend.domain.repository.CarteraRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.LetraRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.PlazoTasaRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.LetraService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LetraServiceImpl implements LetraService {
    @Autowired
    private CarteraRepository carteraRepository;
    @Autowired
    private LetraRepository letraRepository;
    @Autowired
    private PlazoTasaRepository plazoTasaRepository;

    @Override
    public Letra createLetraByCarteraId(Long carteraId, Long plazotasaId, Letra letra) {
        return carteraRepository.findById(carteraId).map(
                cartera -> {
                    return plazoTasaRepository.findById(plazotasaId).map(
                            plazoTasa -> {
                                letra.setCartera(cartera);
                                letra.setPlazoTasa(plazoTasa);
                                letra.setFechaGiro(letra.getFechaGiro());
                                letra.setFechaVencimiento(letra.getFechaVencimiento());
                                letra.setValorNominal(letra.getValorNominal());
                                letra.setRetencion(letra.getRetencion());
                                letra.setNombreEmisor(letra.getNombreEmisor());
                                letra.setMoneda(letra.getMoneda());
                                letra.setFechaDescuento(letra.getFechaDescuento());
                                letra.setDiasAnio(letra.getDiasAnio());
                                letra.setValor(letra.getValor());
                                letra.setTipotasa(letra.isTipotasa());
                                return letraRepository.save(letra);
                            }
                    ).orElseThrow(() -> new ResourceNotFoundException(
                            "PlazoTasa", "Id", plazotasaId
                    ));
                }).orElseThrow(()-> new ResourceNotFoundException(
                "Cartera","Id", carteraId
        ));
    }

    @Override
    public List<Letra> getAllLetrasByCarteraId(Long carteraId) {
        return letraRepository.findAllByCarteraIdCartera(carteraId);
    }

    @Override
    public Optional<Letra> getLetraByIdAndCarteraId(Long carteraId, Long letraId) {
        return letraRepository.findByIdAndCarteraIdCartera(letraId,carteraId);
    }

    @Override
    public Letra updateLetra(Long carteraId, Long letraId, Letra letra) {
        if(!carteraRepository.existsById(carteraId))
            throw new ResourceNotFoundException(
                    "Cartera","Id", carteraId
            );

        return letraRepository.findById(letraId).map(letra1 -> {
            letra1.setDiasTranscurridos(letra.getDiasTranscurridos());
            letra1.setTEP(letra.getTEP());
            letra1.setTDP(letra.getTDP());
            letra1.setTotalGastoInicial(letra.getTotalGastoInicial());
            letra1.setTotalGastoFinal(letra.getTotalGastoFinal());
            letra1.setTotalGastoDescontado(letra.getTotalGastoDescontado());
            letra1.setValorNeto(letra.getValorNeto());
            letra1.setValorRecibido(letra.getValorRecibido());
            letra1.setValorEntregado(letra.getValorEntregado());
            letra1.setTCEA(letra.getTCEA());
            letra1.setTEA(letra.getTEA());
            return letraRepository.save(letra1);
        }).orElseThrow(()-> new ResourceNotFoundException(
                "Letra", "Id", letraId
        ));
    }

    @Override
    public ResponseEntity<?> deleteLetra(Long carteraId, Long letraId) {
        if(!carteraRepository.existsById(carteraId))
            throw new ResourceNotFoundException(
                    "Cartera","Id", carteraId
            );

        return letraRepository.findById(letraId).map(
                letra -> {
                    letraRepository.delete(letra);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("letra", "Id",letraId ));
    }

    @Override
    public Optional<Letra> getLetraById(Long letraid) {
        return letraRepository.findById(letraid);
    }
}
