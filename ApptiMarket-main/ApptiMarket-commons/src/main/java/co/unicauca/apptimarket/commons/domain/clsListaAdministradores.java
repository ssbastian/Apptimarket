package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author David Marín
 */
import java.util.List;

public class clsListaAdministradores {

    //para el json de productos
    private List<clsAdministrador> atrListaProductos;

    public clsListaAdministradores(List<clsAdministrador> prmListaProductos) {
        atrListaProductos = prmListaProductos;
    }

    public clsListaAdministradores() {
    }

    @Override
    public String toString() {
        return "ListaProductos{" + "listaProductos=" + atrListaProductos + '}';
    }

    public List<clsAdministrador> getListaProductos() {
        return atrListaProductos;
    }

}
