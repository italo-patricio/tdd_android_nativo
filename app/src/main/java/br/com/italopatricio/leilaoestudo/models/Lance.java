package br.com.italopatricio.leilaoestudo.models;

import java.io.Serializable;

public class Lance implements Serializable {

    private final Usuario usuario;
    private final double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

}
