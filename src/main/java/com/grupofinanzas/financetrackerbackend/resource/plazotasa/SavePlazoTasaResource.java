package com.grupofinanzas.financetrackerbackend.resource.plazotasa;

public class SavePlazoTasaResource {
    private String nombre;
    private Integer plazo;

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
