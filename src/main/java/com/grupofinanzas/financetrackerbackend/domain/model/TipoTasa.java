package com.grupofinanzas.financetrackerbackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name= "TipoTasa"
)
public class TipoTasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; //1 nominal 2 efectiva
    @NotNull
    private String nombrePlazo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePlazo() {
        return nombrePlazo;
    }

    public void setNombrePlazo(String nombrePlazo) {
        this.nombrePlazo = nombrePlazo;
    }
}
