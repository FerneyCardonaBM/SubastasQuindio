package com.example.subastasquindio.model;

public class Puja {
    private String codigo;
    private Double ofertaInicial;
    private String fechaPuja;

    public Puja() {
        
    }

    // Getters y Setters para los atributos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getOfertaInicial() {
        return ofertaInicial;
    }

    public void setOfertaInicial(Double ofertaInicial) {
        this.ofertaInicial = ofertaInicial;
    }

    public String getFechaPuja() {
        return fechaPuja;
    }

    public void setFechaPuja(String fechaPuja) {
        this.fechaPuja = fechaPuja;
    }


}

