package com.tecnosoporte.cotizacion.strategy;

/**
 * Estrategia concreta para clientes frecuentes.
 * Aplica un descuento del 10%.
 *
 * Responsable: Jesús Alfredo Vásquez Napa (Estudiante 4)
 */
public class ClienteFrecuenteStrategy implements DescuentoStrategy {

    @Override
    public double getPorcentaje() {
        return 0.10;
    }

    @Override
    public String getNombreTipo() {
        return "Frecuente";
    }
}
