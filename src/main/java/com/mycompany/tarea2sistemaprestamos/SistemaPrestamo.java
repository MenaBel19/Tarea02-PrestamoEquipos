/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2sistemaprestamos;

/**
 *
 * @author jimes
 */
public class SistemaPrestamo {
     private Equipo[] equipos = new Equipo[5];
     private int[] diasAtraso = new int[5]; 
     
      public SistemaPrestamo() {
        equipos[0] = new Equipo("EQ01", "Cámara DSLR", "Cámara", true, 500);
        equipos[1] = new Equipo("EQ02", "Trípode", "Soporte", true, 500);
        equipos[2] = new Equipo("EQ03", "Micrófono", "Audio", true, 500);
        equipos[3] = new Equipo("EQ04", "Tableta gráfica", "Diseño", true, 500);
        equipos[4] = new Equipo("EQ05", "Kit de iluminación", "Iluminación", true, 800);
    }
     public String consultarCatalogo() {
    String resultado = "";
    for (int i = 0; i < equipos.length; i++) {
        resultado += (i + 1) + ". " + equipos[i].toString() + "\n";
    }
    return resultado;
}

public String prestarEquipo(int posicion) {
    if (posicion < 1 || posicion > equipos.length) {
        return "Posición fuera de rango.";
    }
    Equipo equipo = equipos[posicion - 1];
    if (equipo.prestar()) {
        diasAtraso[posicion - 1] = 0;   // nuevo préstamo: se limpia el atraso anterior
        return "Equipo prestado: " + equipo.getNombre();
    }
    return "El equipo no está disponible.";
}

public String devolverEquipo(int pocicion, int dias) {
    if (pocicion < 1 || pocicion > equipos.length) {
        return "Posición fuera de rango.";
    }
    if (dias < 0) {
        return "Los días de atraso no pueden ser negativos.";
    }
    Equipo equipo = equipos[pocicion - 1];
    if (!equipo.devolver()) {
        return "Ese equipo no está prestado.";
    }
    diasAtraso[pocicion - 1] = dias;
    int multa = equipo.multa(dias);
    return "Equipo devuelto: " + equipo.getNombre()
         + "\nDías de atraso: " + dias
         + "\nMulta" + multa;
}

public String consultarMultas() {
    String resultado = "";
    for (int i = 0; i < equipos.length; i++) {
        int multa = equipos[i].multa(diasAtraso[i]);
        resultado += (i + 1) + ". " + equipos[i].getNombre()
                   + " | Días de atraso: " + diasAtraso[i]
                   + " | Multa:" + multa + "\n";
    }
    return resultado;
}

public String mostrarResumen() {
    int disponibles = 0;
    int prestados = 0;
    int totalDias = 0;
    int totalMultas = 0;

    for (int i = 0; i < equipos.length; i++) {
        if (equipos[i].isDisponibilidad()) {
            disponibles++;
        } else {
            prestados++;
        }
        totalDias += diasAtraso[i];
        totalMultas += equipos[i].multa(diasAtraso[i]);
    }

    return "Equipos disponibles: " + disponibles
         + "\nEquipos prestados: " + prestados
         + "\nTotal de días de atraso: " + totalDias
         + "\nTotal de multas:" + totalMultas;
}
     
}
