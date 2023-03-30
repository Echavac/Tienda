/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_1Q2023.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class  Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
   
   @JoinColumn(name="id_credito", referencedColumnName ="id_credito")
   @ManyToOne
   private Credito credito;
   
   
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }

 
  
    
}
