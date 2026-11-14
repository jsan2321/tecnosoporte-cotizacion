package com.tecnosoporte.cotizacion.strategy;

/**
 * Contexto del patrón Strategy.
 * Recibe una estrategia de descuento y la aplica sobre un subtotal dado.
 * El controlador no conoce la lógica de descuento; solo usa este contexto.
 *
 * Responsable: Jesús Alfredo Vásquez Napa (Estudiante 4)
 */
public class DescuentoContext {

    private final DescuentoStrategy strategy;

    public DescuentoContext(DescuentoStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calcula el importe de descuento sobre el subtotal recibido.
     */
    public double calcularDescuento(double subtotal) {
        return subtotal * strategy.getPorcentaje();
    }

    public double getPorcentaje() {
        return strategy.getPorcentaje();
    }

    public String getNombreTipo() {
        return strategy.getNombreTipo();
    }
}
