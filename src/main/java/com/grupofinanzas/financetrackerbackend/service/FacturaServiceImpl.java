package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.PlazoTasa;
import com.grupofinanzas.financetrackerbackend.domain.repository.CarteraRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.FacturaRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.PlazoTasaRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.FacturaService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private CarteraRepository carteraRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private PlazoTasaRepository plazoTasaRepository;


    @Override
    public Factura createFacturaByCarteraId(Long carteraId, Long plazotasaId,  Factura factura) {
         return carteraRepository.findById(carteraId).map(
                cartera -> { return plazoTasaRepository.findById(plazotasaId).map(
                        plazoTasa -> {
                            factura.setidCartera(cartera);
                            factura.setidPlazoTasa(plazoTasa);
                            factura.setFechaEmision(factura.getFechaEmision());
                            factura.setFechaPago(factura.getFechaPago());
                            factura.setTotalFacturado(factura.getTotalFacturado());
                            factura.setRetencion(factura.getRetencion());
                            factura.setNombreEmisor(factura.getNombreEmisor());
                            factura.setMoneda(factura.getMoneda());
                            factura.setFechaDescuento(factura.getFechaDescuento());
                            factura.setDiasAnio(factura.getDiasAnio());
                            factura.setValor(factura.getValor());
                            factura.setTipotasa(factura.getTipotasa());
                            return facturaRepository.save(factura);
                        }
                ).orElseThrow(()->new ResourceNotFoundException(
                        "PlazoTasa","Id",plazotasaId
                ));
                }).orElseThrow(()-> new ResourceNotFoundException(
                "Cartera","Id", carteraId
        ));
    }

    @Override
    public List<Factura> getAllFacturasByCarteraId(Long carteraId) {
        return facturaRepository.findAllByCarteraIdCartera(carteraId);
    }

    @Override
    public Optional<Factura> getFacturaByIdAndCarteraId(Long carteraId, Long facturaId) {
        return facturaRepository.findByIdAndCarteraIdCartera(facturaId,carteraId);
    }

    @Override
    public Factura updateFactura(Long carteraId, Long facturaId, Factura factura) {
        if(!carteraRepository.existsById(carteraId))
            throw new ResourceNotFoundException(
                    "Cartera","Id", carteraId
            );

        return facturaRepository.findById(facturaId).map(factura1 -> {
            factura1.setDiasTranscurridos(factura.getDiasTranscurridos());
            factura1.setNombreEmisor(factura.getNombreEmisor());
            factura1.setTEP(factura.getTEP());
            factura1.setTDP(factura.getTDP());
            factura1.setTotalGastoInicial(factura.getTotalGastoInicial());
            factura1.setTotalGastoFinal(factura.getTotalGastoFinal());
            factura1.setTotalGastoDescontado(factura.getTotalGastoDescontado());
            factura1.setValorNeto(factura.getValorNeto());
            factura1.setValorRecibido(factura.getValorRecibido());
            factura1.setValorEntregado(factura.getValorEntregado());
            factura1.setTCEA(factura.getTCEA());
            factura1.setTEA(factura.getTEA());
            return facturaRepository.save(factura1);
        }).orElseThrow(()-> new ResourceNotFoundException(
                "Factura", "Id", facturaId
        ));
    }

    @Override
    public ResponseEntity<?> deleteFactura(Long carteraId, Long facturaId) {
        if(!carteraRepository.existsById(carteraId))
            throw new ResourceNotFoundException(
                    "Cartera","Id", carteraId
            );

        return facturaRepository.findById(facturaId).map(
                factura -> {
                    facturaRepository.delete(factura);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("factura", "Id",facturaId ));
    }

    @Override
    public Optional<Factura> getFacturaById(Long facturaid) {
        return facturaRepository.findById(facturaid);
    }
}
