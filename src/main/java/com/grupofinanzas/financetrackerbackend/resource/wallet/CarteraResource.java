package com.grupofinanzas.financetrackerbackend.resource.wallet;

import com.grupofinanzas.financetrackerbackend.domain.model.User;

public class CarteraResource {
    private Long idCartera;
    private Float totalCostoFinal;
    private Float TCEA;


    public Long getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Long idCartera) {
        this.idCartera = idCartera;
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
}
