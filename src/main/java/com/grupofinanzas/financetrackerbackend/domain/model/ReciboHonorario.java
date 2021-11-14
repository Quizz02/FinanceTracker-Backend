package com.grupofinanzas.financetrackerbackend.domain.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Recibo_Honorario")
@PrimaryKeyJoinColumn(name = "recibo_id")
public class ReciboHonorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date fechaEmision;
    private Date fechaPago;
    private String nombreEmisor;
    private Float valorNominal;//output
    private Float valorEntregado;//output
    private Float valorRecibido;//output
    private Float valorNeto;//output
    private Float retencion;
    private boolean moneda;
    private Float TEP;
    private Float TDP;
    private Float TCEA;//output
    private Integer diasTranscurridos;//calculo fechaemision y pago
    private Float totalGastoInicial;//mismo que factura
    private Float totalGastoFinal;//mismo que factura
    private Float totalGastoDescontada;//ni idea de pa que sirve
    @ManyToOne
    private Cartera cartera;
    @OneToOne
    private Tasa tasa;
    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<GastoFinal> gastosFinales = new ArrayList<>();
    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<GastoInicial> gastosIniciales = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
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

    public Float getTotalGastoDescontada() {
        return totalGastoDescontada;
    }

    public void setTotalGastoDescontada(Float totalGastoDescontada) {
        this.totalGastoDescontada = totalGastoDescontada;
    }

    public Cartera getCartera() {
        return cartera;
    }

    public void setCartera(Cartera idcartera) {
        this.cartera = idcartera;
    }

    public Tasa getTasa() {
        return tasa;
    }

    public void setTasa(Tasa idtasa) {
        this.tasa = idtasa;
    }

    public List<GastoFinal> getGasto_Final() {
        return gastosFinales;
    }

    public void setGasto_Final(List<GastoFinal> gasto_Final) {
        gastosFinales = gasto_Final;
    }

    public List<GastoInicial> getGastosIniciales() {
        return gastosIniciales;
    }

    public void setGastosIniciales(List<GastoInicial> gasto_Iniciales) {
        this.gastosIniciales = gasto_Iniciales;
    }
}
