
package com.Tienda_1Q2023.controller;

import com.Tienda_1Q2023.dao.ClienteDao;
import com.Tienda_1Q2023.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/url")
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
   
   
          var cliente = clienteDao.findAll();
        model.addAttribute("cliente", cliente);
        
        
        return "index";
    }
    
}
