/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2sistemaprestamos;
import javax.swing.JOptionPane;
/**
 *
 * @author jimes
 */
public class Menu {
private SistemaPrestamo sistema;
    public Menu() {
      sistema = new SistemaPrestamo();
    }
     
    public void iniciar(){
    int opcion;
    opcion=0;
        do{
            opcion=Integer.parseInt(JOptionPane.showInputDialog( "SISTEMA DE PRÉSTAMO DE EQUIPOS\n\n"
                + "1. Consultar catálogo\n"
                + "2. Prestar equipo\n"
                + "3. Devolver equipo\n"
                + "4. Consultar multas\n"
                + "5. Mostrar resumen\n"
                + "6. Salir"));
            switch(opcion)
                
            {
            case 1:
                //Consultar catálogo recorre Equipo[] con for y muestra posición, código, nombre, tipo y estado
                 JOptionPane.showMessageDialog(null, sistema.consultarCatalogo());
                    break;
            case 2:
                //Prestar equipo Solicita una posición, valida el rango y presta solo si el equipo está disponible. 
                int posicion=Integer.parseInt(JOptionPane.showInputDialog("Posición del equipo a prestar (1 a 5):"));
                sistema.prestarEquipo(posicion);
                    break;
            case 3:
                //Devolver equipo Devuelve solo un equipo prestado, solicita días de atraso y los guarda en int[].
                 int pocicion=Integer.parseInt(JOptionPane.showInputDialog("Posición del equipo a devolver (1 a 5):"));
                int dias=Integer.parseInt(JOptionPane.showInputDialog("Dias de atraso(0 en caso de no haber):"));
                sistema.devolverEquipo(pocicion, dias);
                    break;
            case 4:
                //Consultar multas Recorre ambos arreglos y muestra los días y la multa del último préstamo de cada equipo. 
                JOptionPane.showMessageDialog(null, sistema.consultarMultas());
                    break;
            case 5:
                //Indica disponibles, prestados, total de días de atraso y total de multas registradas. 
                 JOptionPane.showMessageDialog(null, sistema.mostrarResumen());
                    break;
            case 6:
                //Salir Finaliza el ciclo y muestra un mensaje de despedida.
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Elija de 1 a 6.");
            }
        }while(opcion!=6);
    
    
    }
    
    
}
