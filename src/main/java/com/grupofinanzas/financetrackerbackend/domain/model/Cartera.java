package com.grupofinanzas.financetrackerbackend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "carteras")
@PrimaryKeyJoinColumn(name = "cartera_id")
public class Cartera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idCartera;

//    @Column(
//            name="totalCostoInicial",
//            nullable = false
//    )
//    private Float totalCostoInicial;

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

//    @Column(
//            name="TIR",
//            nullable = false
//    )
//    private Float TIR;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @JoinColumn(
//            name = "idUsuario",
//            nullable = false,
//            referencedColumnName ="id",
//            insertable = false,
//            updatable = false,
//            foreignKey = @ForeignKey(
//                    name="usuariodFK"
//            )
//    )
    private User user;

    @OneToMany
    private List<Factura> facturas = new ArrayList<>();
    @OneToMany
    private List<ReciboHonorario> reciboHonorarios = new ArrayList<>();
    @OneToMany
    private List<Letra> letras = new ArrayList<>();

    public Long getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Long idCartera) {
        this.idCartera = idCartera;
    }

//    public Float getTotalCostoInicial() {
//        return totalCostoInicial;
//    }

//    public void setTotalCostoInicial(Float totalCostoInicial) {
//        this.totalCostoInicial = totalCostoInicial;
//    }

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

//    public Float getTIR() {
//        return TIR;
//    }

//    public void setTIR(Float TIR) {
//        this.TIR = TIR;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User idUsuario) {
        this.user = idUsuario;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<ReciboHonorario> getReciboHonorarios() {
        return reciboHonorarios;
    }

    public void setReciboHonorarios(List<ReciboHonorario> reciboHonorarios) {
        this.reciboHonorarios = reciboHonorarios;
    }

    public List<Letra> getLetras() {
        return letras;
    }

    public void setLetras(List<Letra> letras) {
        this.letras = letras;
    }
}
