
package com.Tienda_1Q2023.controller;

import com.Tienda_1Q2023.domain.Cliente;
import com.Tienda_1Q2023.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
   //     log.info( "Saludos desde MVC");
   //     model.addAttribute( "Mensaje", "Hola desde el controlador");
   //     
   //     Cliente cliente = new Cliente("Edwin", "Chavarria Camacho", "edwin@gmail.com", "70357017");
   //     model.addAttribute( "cliente", cliente);
   //    
   //     Cliente cliente2 = new Cliente("Evanessis", "Ochoa Camacho", "evanesis@gmail.com", "70357017");
   //     Cliente cliente3 = new Cliente("Jeykell", " Chavarria Ochoa", "evanesis@gmail.com", "70357017");
   //     
   //     List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);
   
   
          var cliente = clienteService.getClientes();
        model.addAttribute("cliente", cliente);
        
        
        return "index";
    }
   
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
    
        return "modificarCliente";
    }    
    
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
           clienteService.save(cliente);
        return "redirect:/";
    }  

    @GetMapping("/modificarCliente/{idCliente}")
    public String  modificarCliente(Cliente cliente, Model model){
           cliente = clienteService.getCliente(cliente);
           model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }  
    
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
           clienteService.delete(cliente);
        return "redirect:/";
    }  
    
    
}
