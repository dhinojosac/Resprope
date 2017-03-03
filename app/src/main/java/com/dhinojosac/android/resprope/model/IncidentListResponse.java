
package com.dhinojosac.android.resprope.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncidentListResponse {

    @SerializedName("Lista de incidencias")
    @Expose
    private List<ListaDeIncidencia> listaDeIncidencias = null;

    public List<ListaDeIncidencia> getListaDeIncidencias() {
        return listaDeIncidencias;
    }

    public void setListaDeIncidencias(List<ListaDeIncidencia> listaDeIncidencias) {
        this.listaDeIncidencias = listaDeIncidencias;
    }

}
