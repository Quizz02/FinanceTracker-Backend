package com.grupofinanzas.financetrackerbackend.resource.factura;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grupofinanzas.financetrackerbackend.domain.model.Cartera;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoInicial;
import com.grupofinanzas.financetrackerbackend.domain.model.PlazoTasa;
import com.grupofinanzas.financetrackerbackend.resource.plazotasa.PlazoTasaResource;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaResource {
    private Long id;
    private LocalDate fechaEmision; //input FE
    private LocalDate fechaPago; //input FP
    private String nombreEmisor; // interno name
    private Float totalFacturado;//input TF
    private Float valorEntregado;//output VE
    private Float valorRecibido;//output VR
    private Float valorNeto;//output Vnet
    private Float retencion; //input Rt
    private boolean moneda; //input 1 dolar 0 sol
    private Float TEP;//output TE
    private Float TDP;//output d
    private Float TCEA;//output TCEA
    private Integer diasTranscurridos; //calculo fechaemison pago ND
    private Float totalGastoInicial;//calculo de las instancias de la clase gastoinicial
    private Float totalGastoFinal;//calculo de las instancias de la clase gastofinal
    private Float totalGastoDescontado;// output D
    private LocalDate fechaDescuento; // input FD
    private Integer diasAnio; //input 360 o 365 DA
    private Float valor; /*input valor de la tasa TE,TEA */
    private Float TEA; //output Tasa efectiva anual, calculo de la tasa si es nominal, copia si es efectiva
    private boolean tipotasa; //0 efectiva 1 nominal



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public Float getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(Float valorNominal) {
        this.totalFacturado = valorNominal;
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

    public boolean getMoneda() {
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

    public void setDiasTranscurridos(Integer dias) {
        this.diasTranscurridos = dias;
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

    public void setTotalGastoDescontado(Float totalGastoDescontada) {
        this.totalGastoDescontado = totalGastoDescontada;
    }

    public LocalDate getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(LocalDate fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public Integer getDiasAnio() {
        return diasAnio;
    }

    public void setDiasAnio(Integer diasAnio) {
        this.diasAnio = diasAnio;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public boolean getTipotasa() {
        return tipotasa;
    }

    public void setTipotasa(boolean tipotasa) {
        this.tipotasa = tipotasa;
    }

    public Float getTEA() {
        return TEA;
    }

    public void setTEA(Float TEA) {
        this.TEA = TEA;
    }

}
