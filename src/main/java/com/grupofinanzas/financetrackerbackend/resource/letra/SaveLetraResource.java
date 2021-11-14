package com.grupofinanzas.financetrackerbackend.resource.letra;

import java.sql.Date;

public class SaveLetraResource {
    private Date fechaGiro;
    private Date fechaVencimiento;
    private String nombreEmisor;
    private Float valorNominal;
    private Float valorEntregado;
    private Float valorRecibido;
    private Float valorNeto;
    private Float retencion;
    private boolean moneda;
    private Float TEP;
    private Float TDP;
    private Float TCEA;
    private Integer diasTranscurridos;
    private Float totalGastoInicial;
    private Float totalGastoFinal;
    private Float totalGastoDescontado;

    public Date getFechaGiro() {
        return fechaGiro;
    }

    public void setFechaGiro(Date fechaGiro) {
        this.fechaGiro = fechaGiro;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public Float getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(Float valorNominal) {
        this.valorNominal = valorNominal;
    }

    public Float getValorEntregado() {
        return valorEntregado;
    }

    public void setValorEntregado(Float valorEntregado) {
        this.valorEntregado = valorEntregado;
    }

    public Float getValorRecibido() {
        return valorRecibido;
    }

    public void setValorRecibido(Float valorRecibido) {
        this.valorRecibido = valorRecibido;
    }

    public Float getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(Float valorNeto) {
        this.valorNeto = valorNeto;
    }

    public Float getRetencion() {
        return retencion;
    }

    public void setRetencion(Float retencion) {
        this.retencion = retencion;
    }

    public boolean isMoneda() {
        return moneda;
    }

    public void setMoneda(boolean moneda) {
        this.moneda = moneda;
    }

    public Float getTEP() {
        return TEP;
    }

    public void setTEP(Float TEP) {
        this.TEP = TEP;
    }

    public Float getTDP() {
        return TDP;
    }

    public void setTDP(Float TDP) {
        this.TDP = TDP;
    }

    public Float getTCEA() {
        return TCEA;
    }

    public void setTCEA(Float TCEA) {
        this.TCEA = TCEA;
    }

    public Integer getDiasTranscurridos() {
        return diasTranscurridos;
    }

    public void setDiasTranscurridos(Integer diasTranscurridos) {
        this.diasTranscurridos = diasTranscurridos;
    }

    public Float getTotalGastoInicial() {
        return totalGastoInicial;
    }

    public void setTotalGastoInicial(Float totalGastoInicial) {
        this.totalGastoInicial = totalGastoInicial;
    }

    public Float getTotalGastoFinal() {
        return totalGastoFinal;
    }

    public void setTotalGastoFinal(Float totalGastoFinal) {
        this.totalGastoFinal = totalGastoFinal;
    }

    public Float getTotalGastoDescontado() {
        return totalGastoDescontado;
    }

    public void setTotalGastoDescontado(Float totalGastoDescontado) {
        this.totalGastoDescontado = totalGastoDescontado;
    }
}
