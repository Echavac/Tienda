package com.Tienda_1Q2023.service;

import com.Tienda_1Q2023.dao.ArticuloDao;
import com.Tienda_1Q2023.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activo) {
        List<Articulo> lista = (List<Articulo>) articuloDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
      return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
       articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
       articuloDao.deleteById(articulo.getIdArticulo());
    }
    
}