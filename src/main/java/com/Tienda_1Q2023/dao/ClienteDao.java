
package com.Tienda_1Q2023.dao;

import com.Tienda_1Q2023.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
    public List<Cliente> findByNombre(String nombre);
    
    public List<Cliente> findByApellidos(String apellidos);

    public List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);
}
