
package co.unicauca.apptimarket.commons.domain;

import java.util.List;

/**
 *
 * @author WINDOWS
 */
public class BuyList 
{
    //para el json de productos
    private List<Buy> listaCompras;

    public BuyList(List<Buy> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public BuyList() {
    }
    
    
    @Override
    public String toString() {
        return "ListaProductos{" + "listaProductos=" + this.listaCompras + '}';
    }

    public List<Buy> getListaProductos() {
        return this.listaCompras;
    }
}
