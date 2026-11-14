package com.tecnosoporte.cotizacion.controller;

import com.tecnosoporte.cotizacion.model.CotizacionRequest;
import com.tecnosoporte.cotizacion.model.CotizacionResult;
import com.tecnosoporte.cotizacion.strategy.ClienteFrecuenteStrategy;
import com.tecnosoporte.cotizacion.strategy.ClienteInstitucionalStrategy;
import com.tecnosoporte.cotizacion.strategy.ClienteNuevoStrategy;
import com.tecnosoporte.cotizacion.strategy.DescuentoContext;
import com.tecnosoporte.cotizacion.strategy.DescuentoStrategy;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * Controlador principal de la aplicación de cotización.
 * Gestiona las rutas GET (mostrar formulario) y POST (procesar cotización).
 * Delega el cálculo de descuentos al patrón Strategy; no contiene lógica de descuento propia.
 *
 * Responsable: Alexander Juniors Crisostomo Morales (Estudiante 2)
 */
@Controller
public class CotizacionController {

    /**
     * Precios unitarios por servicio técnico (en soles).
     */
    private static final Map<String, Double> PRECIOS = Map.of(
            "Diagnóstico de computadora", 40.0,
            "Mantenimiento preventivo",   70.0,
            "Instalación de software",    50.0
    );

    /**
     * Muestra el formulario vacío de cotización (GET /).
     */
    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cotizacionRequest", new CotizacionRequest());
        model.addAttribute("servicios", PRECIOS.keySet());
        return "formulario";
    }

    /**
     * Procesa el formulario enviado (POST /cotizar).
     * Valida los datos, selecciona la estrategia de descuento correspondiente
     * y calcula el resultado final de la cotización.
     */
    @PostMapping("/cotizar")
    public String procesarCotizacion(
            @Valid @ModelAttribute("cotizacionRequest") CotizacionRequest request,
            BindingResult bindingResult,
            Model model) {

        // Si hay errores de validación, regresa al formulario con los mensajes
        if (bindingResult.hasErrors()) {
            model.addAttribute("servicios", PRECIOS.keySet());
            return "formulario";
        }

        // Obtener precio unitario del servicio seleccionado
        double precioUnitario = PRECIOS.getOrDefault(request.getServicio(), 0.0);
        double subtotal = precioUnitario * request.getCantidad();

        // Seleccionar estrategia de descuento según tipo de cliente
        DescuentoStrategy strategy = switch (request.getTipoCliente()) {
            case "FRECUENTE"    -> new ClienteFrecuenteStrategy();
            case "INSTITUCIONAL" -> new ClienteInstitucionalStrategy();
            default             -> new ClienteNuevoStrategy();
        };

        DescuentoContext context = new DescuentoContext(strategy);
        double importeDescuento = context.calcularDescuento(subtotal);
        double total = subtotal - importeDescuento;

        // Construir resultado para la vista
        CotizacionResult result = new CotizacionResult();
        result.setNombreCliente(request.getNombreCliente());
        result.setServicio(request.getServicio());
        result.setCantidad(request.getCantidad());
        result.setPrecioUnitario(precioUnitario);
        result.setTipoCliente(context.getNombreTipo());
        result.setSubtotal(subtotal);
        result.setPorcentajeDescuento(context.getPorcentaje() * 100);
        result.setImporteDescuento(importeDescuento);
        result.setTotal(total);

        model.addAttribute("resultado", result);
        return "resultado";
    }
}
