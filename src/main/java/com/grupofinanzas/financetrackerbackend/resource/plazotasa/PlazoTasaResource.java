package com.grupofinanzas.financetrackerbackend.resource.plazotasa;

public class PlazoTasaResource {
    private Long id;
    private String nombre;
    private Integer plazo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

}
