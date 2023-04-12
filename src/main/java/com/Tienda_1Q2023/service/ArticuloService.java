package com.Tienda_1Q2023.service;

import com.Tienda_1Q2023.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activo);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);
}
