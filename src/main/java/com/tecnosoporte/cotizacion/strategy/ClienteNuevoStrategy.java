package com.tecnosoporte.cotizacion.strategy;

/**
 * Estrategia concreta para clientes nuevos.
 * No aplica ningún descuento (0%).
 *
 * Responsable: Jesús Alfredo Vásquez Napa (Estudiante 4)
 */
public class ClienteNuevoStrategy implements DescuentoStrategy {

    @Override
    public double getPorcentaje() {
        return 0.0;
    }

    @Override
    public String getNombreTipo() {
        return "Nuevo";
    }
}
