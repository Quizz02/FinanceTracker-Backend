package com.grupofinanzas.financetrackerbackend.resource.plazotasa;

import java.util.Date;

public class SavePlazoTasaResource {
    private String nombre;
    private Date plazo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getPlazo() {
        return plazo;
    }

    public void setPlazo(Date plazo) {
        this.plazo = plazo;
    }

}
