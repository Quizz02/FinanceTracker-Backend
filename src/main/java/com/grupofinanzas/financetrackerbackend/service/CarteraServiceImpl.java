package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Cartera;
import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.Letra;
import com.grupofinanzas.financetrackerbackend.domain.model.ReciboHonorario;
import com.grupofinanzas.financetrackerbackend.domain.repository.*;
import com.grupofinanzas.financetrackerbackend.domain.service.CarteraService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteraServiceImpl implements CarteraService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarteraRepository carteraRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private LetraRepository letraRepository;
    @Autowired
    private ReciboRepository reciboRepository;


    @Override
    public Cartera createCarteraByUserId(Long userId, Cartera cartera) {
        return userRepository.findById(userId).map(
                        user -> {
                            cartera.setUser(user);
//                            cartera.setTotalCostoInicial(0.0F);
                            cartera.setTotalCostoFinal(0.0F);
//                            cartera.setTIR(0.0F);
                            cartera.setTCEA(0.0F);
                            return carteraRepository.save(cartera);
                        }
                )
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId
                ));
    }

    @Override
    public Optional<Cartera> getCarteraByIdAndByUserId(Long userId, Long carteraid) {
        return carteraRepository.findByIdCarteraAndUserId(carteraid,userId);
    }

    @Override
    public Cartera updateCartera(Long userId,Long carteraId , Cartera cartera) {
                        if(!userRepository.existsById(userId))
                            throw new ResourceNotFoundException("User", "Id", userId);
                        return carteraRepository.findById(carteraId).map(
                                cartera1 -> {
                                    cartera1.setTCEA(cartera.getTCEA());
//                                    cartera1.setTIR(cartera.getTIR());
                                    cartera1.setTotalCostoFinal(cartera.getTotalCostoFinal());
//                                    cartera1.setTotalCostoInicial(cartera.getTotalCostoInicial());
                                return carteraRepository.save(cartera1);
                        }
        ).orElseThrow(()-> new ResourceNotFoundException("Cartera", "Id", carteraId));
    }

    @Override
    public ResponseEntity<?> deleteCartera(Long userId, Long carteraId) {
        if(!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException(
                    "User", "Id", userId
            );
        }

        List<Factura> facturaList = facturaRepository.findAllByCarteraIdCartera(carteraId);
        List<Letra> letraList = letraRepository.findAllByCarteraIdCartera(carteraId);
        List<ReciboHonorario> reciboHonorarioList = reciboRepository.findAllByCarteraIdCartera(carteraId);

        if(facturaList!=null){
            for (Factura factura:facturaList){
                facturaRepository.delete(factura);
            }
        }

        if(letraList!=null){
            for (Letra letra:letraList){
                letraRepository.delete(letra);
            }
        }

        if(reciboHonorarioList!=null){
            for (ReciboHonorario reciboHonorario:reciboHonorarioList){
                reciboRepository.delete(reciboHonorario);
            }
        }

        return carteraRepository.findById(carteraId).map(
                cartera -> {
                    carteraRepository.delete(cartera);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("cartera", "Id",carteraId ));
    }


    @Override
    public List<Cartera> getAllCarterasByUserId(Long userId) {
        return carteraRepository.findAllByUserId(userId);
    }
}
