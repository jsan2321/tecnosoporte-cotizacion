package com.tecnosoporte.cotizacion.model;

/**
 * Modelo que representa el resultado calculado de una cotización.
 * Contiene subtotal, descuento aplicado y total final para mostrarse en la vista.
 *
 * Responsable: José Antonio Santiago Caraza (Estudiante 1)
 */
public class CotizacionResult {

    private String nombreCliente;
    private String servicio;
    private int cantidad;
    private double precioUnitario;
    private String tipoCliente;
    private double subtotal;
    private double porcentajeDescuento;
    private double importeDescuento;
    private double total;

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getImporteDescuento() {
        return importeDescuento;
    }

    public void setImporteDescuento(double importeDescuento) {
        this.importeDescuento = importeDescuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
