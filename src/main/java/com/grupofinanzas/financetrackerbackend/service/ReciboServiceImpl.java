package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.ReciboHonorario;
import com.grupofinanzas.financetrackerbackend.domain.repository.CarteraRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.PlazoTasaRepository;
import com.grupofinanzas.financetrackerbackend.domain.repository.ReciboRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.ReciboService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReciboServiceImpl implements ReciboService {
    @Autowired
    private CarteraRepository carteraRepository;
    @Autowired
    private ReciboRepository reciboRepository;
    @Autowired
    private PlazoTasaRepository plazoTasaRepository;

    @Override
    public ReciboHonorario createReciboByCarteraId(Long carteraId, Long plazotasaId, ReciboHonorario reciboHonorario) {
        return carteraRepository.findById(carteraId).map(
                cartera -> { return plazoTasaRepository.findById(plazotasaId).map(
                        plazoTasa -> {
                            reciboHonorario.setCartera(cartera);
                            reciboHonorario.setPlazoTasa(plazoTasa);
                            reciboHonorario.setFechaEmision(reciboHonorario.getFechaEmision());
                            reciboHonorario.setFechaPago(reciboHonorario.getFechaPago());
                            reciboHonorario.setTotalRecibir(reciboHonorario.getTotalRecibir());
                            reciboHonorario.setRetencion(reciboHonorario.getRetencion());
                            reciboHonorario.setNombreEmisor(reciboHonorario.getNombreEmisor());
                            reciboHonorario.setMoneda(reciboHonorario.getMoneda());
                            reciboHonorario.setFechaDescuento(reciboHonorario.getFechaDescuento());
                            reciboHonorario.setDiasAnio(reciboHonorario.getDiasAnio());
                            reciboHonorario.setValor(reciboHonorario.getValor());
                            reciboHonorario.setTipotasa(reciboHonorario.isTipotasa());
                            return reciboRepository.save(reciboHonorario);
                        }
                ).orElseThrow(()-> new ResourceNotFoundException(
                        "PlazoTasa","Id",plazotasaId
                ));

                }).orElseThrow(()-> new ResourceNotFoundException(
                "Cartera","Id", carteraId
        ));
    }

    @Override
    public List<ReciboHonorario> getAllRecibosByCarteraId(Long carteraId) {
        return reciboRepository.findAllByCarteraIdCartera(carteraId);
    }

    @Override
    public Optional<ReciboHonorario> getReciboByIdAndCarteraId(Long carteraId, Long reciboId) {
        return reciboRepository.findByIdAndCarteraIdCartera(reciboId,carteraId);
    }

    @Override
    public ReciboHonorario updateRecibo(Long carteraId, Long reciboId, ReciboHonorario reciboHonorario) {
        if(!carteraRepository.existsById(carteraId))
            throw new ResourceNotFoundException(
                    "Cartera","Id", carteraId
            );

        return reciboRepository.findById(reciboId).map(reciboHonorario1 -> {
            reciboHonorario1.setDiasTranscurridos(reciboHonorario.getDiasTranscurridos());
            reciboHonorario1.setTEP(reciboHonorario.getTEP());
            reciboHonorario1.setTDP(reciboHonorario.getTDP());
            reciboHonorario1.setTotalGastoInicial(reciboHonorario.getTotalGastoInicial());
            reciboHonorario1.setTotalGastoFinal(reciboHonorario.getTotalGastoFinal());
            reciboHonorario1.setTotalGastoDescontado(reciboHonorario.getTotalGastoDescontado());
            reciboHonorario1.setValorNeto(reciboHonorario.getValorNeto());
            reciboHonorario1.setValorRecibido(reciboHonorario.getValorRecibido());
            reciboHonorario1.setValorEntregado(reciboHonorario.getValorEntregado());
            reciboHonorario1.setTCEA(reciboHonorario.getTCEA());
            reciboHonorario1.setTEA(reciboHonorario.getTEA());
            return reciboRepository.save(reciboHonorario1);
        }).orElseThrow(()-> new ResourceNotFoundException(
                "Recibo", "Id", reciboId
        ));
    }

    @Override
    public ResponseEntity<?> deleteRecibo(Long carteraId, Long reciboId) {
        if(!carteraRepository.existsById(carteraId))
            throw new ResourceNotFoundException(
                    "Cartera","Id", carteraId
            );

        return reciboRepository.findById(reciboId).map(
                reciboHonorario -> {
                    reciboRepository.delete(reciboHonorario);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("recibo", "Id",reciboId ));
    }

    @Override
    public Optional<ReciboHonorario> getReciboById(long reciboid) {
        return reciboRepository.findById(reciboid);
    }
}
