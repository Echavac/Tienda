
package com.Tienda_1Q2023.service;

import com.Tienda_1Q2023.dao.CategoriaDao;
import com.Tienda_1Q2023.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
     @Autowired
    CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        List<Categoria> lista = (List<Categoria>) categoriaDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
      return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
       categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
       categoriaDao.deleteById(categoria.getIdCategoria());
    }
    
}
