package com.grupofinanzas.financetrackerbackend.resource.gastosfacturas;

public class SaveGastoFinalResource {
    private Float monto;
    private String motivo;


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
