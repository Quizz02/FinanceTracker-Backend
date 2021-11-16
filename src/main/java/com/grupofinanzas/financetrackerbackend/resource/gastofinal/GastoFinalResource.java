package com.grupofinanzas.financetrackerbackend.resource.gastofinal;

import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.Letra;
import com.grupofinanzas.financetrackerbackend.domain.model.ReciboHonorario;

import javax.persistence.ManyToOne;

public class GastoFinalResource {
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
