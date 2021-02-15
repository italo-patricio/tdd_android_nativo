package br.com.italopatricio.leilaoestudo.models;

import java.io.Serializable;

public class Lance implements Serializable, Comparable {

    private final Usuario usuario;
    private final double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(Object o) {
        Lance lance = (Lance) o;
        if(valor > lance.getValor()){
            return -1;
        }

        if(valor < lance.getValor()){
            return 1;
        }
        return 0;
    }
}
