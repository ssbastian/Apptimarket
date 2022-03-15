package co.unicauca.apptimarket.commons.domain;

import java.util.List;

/**
 *
 * @author juan sebastian
 */
public class ListaProductos {
    //para el json de productos
    private List<Product> listaProductos;

    public ListaProductos(List<Product> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ListaProductos() {
    }
    
    
    @Override
    public String toString() {
        return "ListaProductos{" + "listaProductos=" + this.listaProductos + '}';
    }

    public List<Product> getListaProductos() {
        return this.listaProductos;
    }
    
    
}