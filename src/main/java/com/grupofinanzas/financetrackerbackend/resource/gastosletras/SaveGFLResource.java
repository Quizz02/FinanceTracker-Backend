package com.grupofinanzas.financetrackerbackend.resource.gastosletras;

public class SaveGFLResource {
    private Float monto;
    private String motivo;

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
