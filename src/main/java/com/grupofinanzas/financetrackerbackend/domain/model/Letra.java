package com.grupofinanzas.financetrackerbackend.domain.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name= " Factura"
)
public class Letra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private DateFormat fechaEmision;
    private DateFormat fechaPago;
    private String nombreEmisor;
    private Float valorNominal;
    private Float valorEntregado;
    private Float valorRecibido;
    private Float valorNeto;
    private Float retencion;
    private Bool moneda;
    private Float TEP;
    private Float TDP;
    private Float TCEA;
    private Integer dias;
    private Float totalGastoInicial;
    private Float totalGastoFinal;
    private Float totalGastoDescontada;
    @ManyToOne
    private Cartera idcartera;
    @OneToOne
    private Tasa idtasa;
    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Gasto_Final> Gasto_Final = new ArrayList<>();
    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Gasto_Inicial> Gasto_Iniciales = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateFormat getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(DateFormat fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public DateFormat getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(DateFormat fechaPago) {
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

    public Bool getMoneda() {
        return moneda;
    }

    public void setMoneda(Bool moneda) {
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

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
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

    public Cartera getIdcartera() {
        return idcartera;
    }

    public void setIdcartera(Cartera idcartera) {
        this.idcartera = idcartera;
    }

    public Tasa getIdtasa() {
        return idtasa;
    }

    public void setIdtasa(Tasa idtasa) {
        this.idtasa = idtasa;
    }

    public List<com.grupofinanzas.financetrackerbackend.domain.model.Gasto_Final> getGasto_Final() {
        return Gasto_Final;
    }

    public void setGasto_Final(List<com.grupofinanzas.financetrackerbackend.domain.model.Gasto_Final> gasto_Final) {
        Gasto_Final = gasto_Final;
    }

    public List<Gasto_Inicial> getGasto_Iniciales() {
        return Gasto_Iniciales;
    }

    public void setGasto_Iniciales(List<Gasto_Inicial> gasto_Iniciales) {
        Gasto_Iniciales = gasto_Iniciales;
    }
}
