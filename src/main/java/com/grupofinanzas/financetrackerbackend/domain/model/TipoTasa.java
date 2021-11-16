package com.grupofinanzas.financetrackerbackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tipo_Tasa")
@PrimaryKeyJoinColumn(name = "tipoTasa_id")
public class TipoTasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; //1 nominal 2 efectiva
    @NotNull
    private String nombrePlazo;
    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Tasa> Tasas = new ArrayList<>();

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

    public List<Tasa> getTasas() {
        return Tasas;
    }


    public void setTasas(List<Tasa> tasas) {
        this.Tasas = tasas;
    }

}
