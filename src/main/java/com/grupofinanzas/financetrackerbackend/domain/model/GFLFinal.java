package com.grupofinanzas.financetrackerbackend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="Gasto_FinalL")
@PrimaryKeyJoinColumn(name = "gastoFinalL_id")
public class GFLFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Float monto;
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "letra_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Letra letra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMonto(Float monto){
        this.monto=monto;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }
}
