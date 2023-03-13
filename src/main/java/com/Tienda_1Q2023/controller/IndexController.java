
package com.Tienda_1Q2023.controller;

import com.Tienda_1Q2023.domain.Articulo;
import com.Tienda_1Q2023.service.ArticuloService;
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
    ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model) {
   
        var articulo = articuloService.getArticulos(true);
        model.addAttribute("articulo", articulo);
        
        
        return "index";
    }
     
       
}
