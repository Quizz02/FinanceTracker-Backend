package com.grupofinanzas.financetrackerbackend.resource.gastosrecibos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grupofinanzas.financetrackerbackend.domain.model.ReciboHonorario;

import javax.persistence.*;

public class GIRResource {
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

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
