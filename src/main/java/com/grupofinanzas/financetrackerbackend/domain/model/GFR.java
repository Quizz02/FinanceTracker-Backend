package com.grupofinanzas.financetrackerbackend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="Gasto_FinalR")
@PrimaryKeyJoinColumn(name = "gastoFinalR_id")
public class GFR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Float monto;
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "Recibo_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ReciboHonorario reciboHonorario;

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

    public ReciboHonorario getReciboHonorario() {
        return reciboHonorario;
    }

    public void setReciboHonorario(ReciboHonorario reciboHonorario) {
        this.reciboHonorario = reciboHonorario;
    }
}
