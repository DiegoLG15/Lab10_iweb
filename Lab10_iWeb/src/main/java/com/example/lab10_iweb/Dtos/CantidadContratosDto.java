package com.example.lab10_iweb.Dtos;

public class CantidadContratosDto {
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadPorEstado() {
        return cantidadPorEstado;
    }

    public void setCantidadPorEstado(int cantidadPorEstado) {
        this.cantidadPorEstado = cantidadPorEstado;
    }

    private int cantidadPorEstado;

}
