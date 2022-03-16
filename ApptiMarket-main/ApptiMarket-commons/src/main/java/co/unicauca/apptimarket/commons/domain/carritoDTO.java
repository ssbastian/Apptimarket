
package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public class carritoDTO {
    
    private String Codigo;
    private String Nombre;
    private String Precio;
    private int Cantidad;


    public carritoDTO(String Codigo, String Nombre, String Precio, int Cantidad) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
  
    }

    
    
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

  public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    
    
}
