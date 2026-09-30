/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2sistemaprestamos;

/**
 *
 * @author jimes
 */
public class Equipo {
    private String codigo;
    private String nombre;
    private String tipo;
    private boolean disponibilidad;
    private int tarifaMulta;

    public Equipo() {
    }
    
    public Equipo (String codigo, String nombre, String tipo, boolean disponibilidad, int tarifaMulta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.tarifaMulta = tarifaMulta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getTarifaMulta() {
        return tarifaMulta;
    }

    public void setTarifaMulta(int tarifaMulta) {
        this.tarifaMulta = tarifaMulta;
    }
    
   public boolean prestar() {
    if (this.disponibilidad) {
        this.disponibilidad = false;
        return true;     // se pudo prestar
    }
    return false;        // ya estaba prestado
   }
    public boolean devolver() {
    if (!this.disponibilidad) {
        this.disponibilidad = true;
        return true;     // se pudo devolver
    }
    return false;        // no estaba prestado
    }

    @Override
    public String toString() {
        return "Menu{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", disponibilidad=" + disponibilidad + ", tarifaMulta=" + tarifaMulta + '}';
    }
    public int multa(int diasAtraso){
    
    if (diasAtraso <= 0) {
        return 0;
    }
    return diasAtraso * tarifaMulta;

    }
    
    
   
    
}
