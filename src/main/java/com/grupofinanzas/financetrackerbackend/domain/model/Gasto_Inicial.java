package com.grupofinanzas.financetrackerbackend.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(
        name="categoria"
)
public class Gasto_Inicial {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;
        private Float monto;
        private String motivo;
        @ManyToOne
        private Factura idFactura;
        @ManyToOne
        private Letra idLetra;
        @ManyToOne
        private Recibo_Honorario idrecibo;

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

        public Factura getIdFactura() {
                return idFactura;
        }

        public void setIdFactura(Factura idFactura) {
                this.idFactura = idFactura;
        }

        public Letra getIdLetra() {
                return idLetra;
        }

        public void setIdLetra(Letra idLetra) {
                this.idLetra = idLetra;
        }

        public Recibo_Honorario getIdrecibo() {
                return idrecibo;
        }

        public void setIdrecibo(Recibo_Honorario idrecibo) {
                this.idrecibo = idrecibo;
        }
}
