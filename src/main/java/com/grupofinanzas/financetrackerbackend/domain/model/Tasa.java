package com.grupofinanzas.financetrackerbackend.domain.model;


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
    private PlazoTasa idPlazoTasa;
    @OneToOne
    private TipoTasa idTipoTasa;

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

    public PlazoTasa getIdPlazoTasa() {
        return idPlazoTasa;
    }

    public void setIdPlazoTasa(PlazoTasa idPlazoTasa) {
        this.idPlazoTasa = idPlazoTasa;
    }

    public TipoTasa getIdTipoTasa() {
        return idTipoTasa;
    }

    public void setIdTipoTasa(TipoTasa idTipoTasa) {
        this.idTipoTasa = idTipoTasa;
    }
}
