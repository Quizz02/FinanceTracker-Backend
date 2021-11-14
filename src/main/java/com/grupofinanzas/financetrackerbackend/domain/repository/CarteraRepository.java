package com.grupofinanzas.financetrackerbackend.domain.repository;

import com.grupofinanzas.financetrackerbackend.domain.model.Cartera;
import com.grupofinanzas.financetrackerbackend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera, Long> {
    List<Cartera> findAllByUserId(Long userId);
    Optional<Cartera> findByIdCarteraAndUserId(Long carteraId, Long userId);
}
