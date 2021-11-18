package com.grupofinanzas.financetrackerbackend.resource.gastosletras;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grupofinanzas.financetrackerbackend.domain.model.Letra;

import javax.persistence.*;

public class GFLResource {
    private Long id;
    private Float monto;
    private String motivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    public void setMonto(Float monto) {
        this.monto = monto;
    }
}
