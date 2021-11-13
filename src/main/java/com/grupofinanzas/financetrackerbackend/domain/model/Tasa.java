package com.grupofinanzas.financetrackerbackend.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name= "Tasa"
)
public class Tasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date fechaDescuento;
    private Integer diasAnio;
    private Float valor; /*valor de la tasa*/
    @OneToOne
    private  Plazo_Tasa idPlazoTasa;
    @OneToOne
    private  Tipo_Tasa idTipoTasa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(Date fechaDescuento) {
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

    public Plazo_Tasa getIdPlazoTasa() {
        return idPlazoTasa;
    }

    public void setIdPlazoTasa(Plazo_Tasa idPlazoTasa) {
        this.idPlazoTasa = idPlazoTasa;
    }

    public Tipo_Tasa getIdTipoTasa() {
        return idTipoTasa;
    }

    public void setIdTipoTasa(Tipo_Tasa idTipoTasa) {
        this.idTipoTasa = idTipoTasa;
    }
}
