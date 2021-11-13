package com.grupofinanzas.financetrackerbackend.resource.wallet;

import com.grupofinanzas.financetrackerbackend.domain.model.User;

public class CarteraResource {
    private Long idCartera;
    private Float totalCostoInicial;
    private Float totalCostoFinal;
    private Float TCEA;
    private Float TIR;
    private User idUsuario;


    public Long getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Long idCartera) {
        this.idCartera = idCartera;
    }

    public Float getTotalCostoInicial() {
        return totalCostoInicial;
    }

    public void setTotalCostoInicial(Float totalCostoInicial) {
        this.totalCostoInicial = totalCostoInicial;
    }

    public Float getTotalCostoFinal() {
        return totalCostoFinal;
    }

    public void setTotalCostoFinal(Float totalCostoFinal) {
        this.totalCostoFinal = totalCostoFinal;
    }

    public Float getTCEA() {
        return TCEA;
    }

    public void setTCEA(Float TCEA) {
        this.TCEA = TCEA;
    }

    public Float getTIR() {
        return TIR;
    }

    public void setTIR(Float TIR) {
        this.TIR = TIR;
    }

    public User getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(User idUsuario) {
        this.idUsuario = idUsuario;
    }
}
