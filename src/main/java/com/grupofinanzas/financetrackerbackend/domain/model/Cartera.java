package com.grupofinanzas.financetrackerbackend.domain.model;

import javax.persistence.*;

@Entity
@Table(
        name= " Cartera"
)
public class Cartera {
    @Id
    @SequenceGenerator(
            name="Cartera_sequence",
            sequenceName = "Cartera_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "tienda_sequence"

    )
    @Column(
            name="id",
            nullable = false
    )
    private Long idCartera;

    @Column(
            name="totalCostoInicial",
            nullable = false
    )
    private Float totalCostoInicial;

    @Column(
            name="totalCostoFinal",
            nullable = false
    )
    private Float totalCostoFinal;

    @Column(
            name="TCEA",
            nullable = false
    )
    private Float TCEA;

    @Column(
            name="TIR",
            nullable = false
    )
    private Float TIR;
    @ManyToOne
    @JoinColumn(
            name = "idUsuario",
            nullable = false,
            referencedColumnName ="id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(
                    name="usuariodFK"
            )
    )
    private User idUsuario;

    public Long getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Long idCartera) {
        this.idCartera = idCartera;
    }

    public Float getTotalCostoInicial() {
        return totalCostoInicial;
    }

    public void setTotalCostoInicial(Float totalCostoInicial) {
        this.totalCostoInicial = totalCostoInicial;
    }

    public Float getTotalCostoFinal() {
        return totalCostoFinal;
    }

    public void setTotalCostoFinal(Float totalCostoFinal) {
        this.totalCostoFinal = totalCostoFinal;
    }

    public Float getTCEA() {
        return TCEA;
    }

    public void setTCEA(Float TCEA) {
        this.TCEA = TCEA;
    }

    public Float getTIR() {
        return TIR;
    }

    public void setTIR(Float TIR) {
        this.TIR = TIR;
    }

    public User getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(User idUsuario) {
        this.idUsuario = idUsuario;
    }
}
