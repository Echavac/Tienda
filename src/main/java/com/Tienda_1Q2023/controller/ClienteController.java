
package com.Tienda_1Q2023.controller;

import com.Tienda_1Q2023.domain.Cliente;
import com.Tienda_1Q2023.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        
    var clientes = clienteService.getClientes();
   // var clientes = clienteService.getClientePorNombre("Ana");
   // var clientes = clienteService.getClientePorApellidos("Mora");
    model.addAttribute("clientes", clientes);
     return "/cliente/listado";
    }
   
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modificar";
    }    
    
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }  

    @GetMapping("/cliente/modificar/{idCliente}")
    public String  modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }  
    
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }  
    
    @GetMapping("/cliente/buscar")
    public String buscar(Cliente cliente){
       return "/cliente/buscarCliente";
    }
    
    @PostMapping("/cliente/busqueda")
    public String busqueda(Cliente cliente, Model model){
      var clientes = clienteService.getClientePorNombre(cliente.getNombre());
      model.addAttribute("resultados", clientes);
      return "/cliente/buscarCliente";
    }
}
