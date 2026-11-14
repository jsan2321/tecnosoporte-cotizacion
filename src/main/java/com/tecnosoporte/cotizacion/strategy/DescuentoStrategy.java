package com.tecnosoporte.cotizacion.strategy;

/**
 * Interfaz Strategy para el cálculo de descuentos.
 * Cada tipo de cliente tiene su propia implementación concreta.
 * Esto permite agregar nuevos tipos de descuento sin modificar el controlador.
 *
 * Responsable: Jesús Alfredo Vásquez Napa (Estudiante 4)
 */
public interface DescuentoStrategy {

    /**
     * Retorna el porcentaje de descuento aplicable (entre 0.0 y 1.0).
     * Ejemplo: 0.10 representa un 10%.
     */
    double getPorcentaje();

    /**
     * Retorna el nombre legible del tipo de cliente para mostrarlo en la vista.
     */
    String getNombreTipo();
}
