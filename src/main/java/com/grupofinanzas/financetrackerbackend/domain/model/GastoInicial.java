package com.grupofinanzas.financetrackerbackend.domain.model;

import javax.persistence.*;

@Entity
@Table(
        name="categoria"
)
public class GastoInicial {
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
        private ReciboHonorario idrecibo;

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

        public ReciboHonorario getIdrecibo() {
                return idrecibo;
        }

        public void setIdrecibo(ReciboHonorario idrecibo) {
                this.idrecibo = idrecibo;
        }
}
