package com.tecnosoporte.cotizacion.strategy;

/**
 * Estrategia concreta para clientes institucionales.
 * Aplica un descuento del 15%.
 *
 * Responsable: Jesús Alfredo Vásquez Napa (Estudiante 4)
 */
public class ClienteInstitucionalStrategy implements DescuentoStrategy {

    @Override
    public double getPorcentaje() {
        return 0.15;
    }

    @Override
    public String getNombreTipo() {
        return "Institucional";
    }
}
