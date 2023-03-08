
package com.Tienda_1Q2023.service;

import com.Tienda_1Q2023.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
   public List<Cliente> getClientes();
    
   public Cliente getCliente(Cliente cliente);
   
   public void save(Cliente cliente);
   
   public void delete(Cliente cliente);
   
   
   
}
