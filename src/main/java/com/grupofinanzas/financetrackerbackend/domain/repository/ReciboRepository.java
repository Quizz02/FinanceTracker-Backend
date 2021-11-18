package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.ReciboHonorario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReciboRepository extends JpaRepository<ReciboHonorario, Long> {
    List<ReciboHonorario> findAllByCarteraIdCartera(Long carteraId);
    Optional<ReciboHonorario> findByIdAndCarteraIdCartera(Long reciboId, Long carteraId);
    Optional<ReciboHonorario> findById(Long id);

}
