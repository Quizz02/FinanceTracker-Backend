package com.grupofinanzas.financetrackerbackend.domain.model;

import javax.persistence.*;

@Entity
@Table(name="Gasto_Final")
@PrimaryKeyJoinColumn(name = "gastoFinal_id")
public class GastoFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Float monto;
    private String motivo;
    @ManyToOne
    private Factura factura;
    @ManyToOne
    private Letra letra;
    @ManyToOne
    private ReciboHonorario recibo;

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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura idFactura) {
        this.factura = idFactura;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra idLetra) {
        this.letra = idLetra;
    }

    public ReciboHonorario getRecibo() {
        return recibo;
    }

    public void setRecibo(ReciboHonorario idrecibo) {
        this.recibo = idrecibo;
    }
}
