package com.tecnosoporte.cotizacion.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Modelo que representa los datos ingresados en el formulario de cotización.
 * Contiene las validaciones de entrada para los campos del cliente.
 *
 * Responsable: José Antonio Santiago Caraza (Estudiante 1)
 */
public class CotizacionRequest {

    @NotBlank(message = "El nombre del cliente no puede estar vacío.")
    private String nombreCliente;

    @NotBlank(message = "Debe seleccionar un servicio.")
    private String servicio;

    @NotNull(message = "La cantidad es obligatoria.")
    @Min(value = 1, message = "La cantidad mínima es 1.")
    @Max(value = 5, message = "La cantidad máxima es 5.")
    private Integer cantidad;

    @NotBlank(message = "Debe seleccionar el tipo de cliente.")
    private String tipoCliente;

    // --- Getters y Setters ---

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
