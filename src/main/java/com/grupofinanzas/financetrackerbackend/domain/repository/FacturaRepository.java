package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findAllByCarteraIdCartera(Long carteraId);
    Optional<Factura> findByIdAndCarteraIdCartera(Long facturaId, Long carteraId);
}
