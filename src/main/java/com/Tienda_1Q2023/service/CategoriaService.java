
package com.Tienda_1Q2023.service;

import com.Tienda_1Q2023.domain.Categoria;
import java.util.List;

public interface CategoriaService {
     public List<Categoria> getCategorias(boolean activo);
    
   public Categoria getCategoria(Categoria categoria);
   
   public void save(Categoria categoria);
   
   public void delete(Categoria categoria);
}
