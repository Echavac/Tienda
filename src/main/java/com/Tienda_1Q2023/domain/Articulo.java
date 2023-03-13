
package com.Tienda_1Q2023.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="articulo")
public class Articulo {
    
     private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticulo;
    private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;

    public Articulo() {
    }

    public Articulo(Long idCategoria, String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
    
    
    
    
}
