package com.grupofinanzas.financetrackerbackend.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Factura")
@PrimaryKeyJoinColumn(name = "factura_id")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaEmision; //input FE
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaPago; //input FP
    private String nombreEmisor; // interno name
    private Float totalFacturado; //input TF
    private Float valorEntregado;//output VE
    private Float valorRecibido;//output VR
    private Float valorNeto;//output Vnet
    private Float retencion; //input Rt
    private boolean moneda; //input 1 dolar 0 sol
    private Float TEP;//output TE
    private Float TDP;//output d
    private Float TCEA;//output TCEA
    private Integer diasTranscurridos; ///calculo fechaemison pago ND
    private Float totalGastoInicial;//calculo de las instancias de la clase gastoinicial
    private Float totalGastoFinal;//calculo de las instancias de la clase gastofinal
    private Float totalGastoDescontado;// output D
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaDescuento;// input ºFD
    private Integer diasAnio; //input 360 o 365 DA
    private Float valor; /*input valor de la tasa TE,TEA */
    private Float TEA; //output Tasa efectiva anual, calculo de la tasa si es nominal, copia si es efectiva
    private boolean tipotasa;  //0 efectiva 1 nominal
    @ManyToOne
    @JoinColumn(name = "plazo_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PlazoTasa plazoTasa;  // dias del plazo P
    @ManyToOne
    @JoinColumn(name = "cartera_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cartera cartera;
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

    public Cartera getidCartera() {
        return cartera;
    }

    public void setidCartera(Cartera idcartera) {
        this.cartera = idcartera;
    }


    public List<GastoFinal> getGastosFinales() {
        return gastosFinales;
    }

    public void setGastosFinales(List<GastoFinal> gastosFinales) {
        this.gastosFinales = gastosFinales;
    }

    public List<GastoInicial> getGastosIniciales() {
        return gastosIniciales;
    }

    public void setGastosIniciales(List<GastoInicial> gastosIniciales) {
        this.gastosIniciales = gastosIniciales;
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

    public PlazoTasa getidPlazoTasa() {
        return plazoTasa;
    }

    public void setidPlazoTasa(PlazoTasa plazoTasa) {
        this.plazoTasa = plazoTasa;
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
