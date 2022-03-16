
package co.unicauca.apptimarket.client.domain;

/**
 *
 * @author WINDOWS
 */
public class ClienteRapido 
{
    private String atrNombre;
    private String atrID;
    private String atrDireccion;
    private String atrTelefono;

    public ClienteRapido(){}
    
    public ClienteRapido(String atrNombre, String atrID, String atrDireccion, String atrTelefono) {
        this.atrNombre = atrNombre;
        this.atrID = atrID;
        this.atrDireccion = atrDireccion;
        this.atrTelefono = atrTelefono;
    }  
    
    public String getAtrNombre() {
        return atrNombre;
    }

    public void setAtrNombre(String atrNombre) {
        this.atrNombre = atrNombre;
    }

    public String getAtrID() {
        return atrID;
    }

    public void setAtrID(String atrID) {
        this.atrID = atrID;
    }

    public String getAtrDireccion() {
        return atrDireccion;
    }

    public void setAtrDireccion(String atrDireccion) {
        this.atrDireccion = atrDireccion;
    }

    public String getAtrTelefono() {
        return atrTelefono;
    }

    public void setAtrTelefono(String atrTelefono) {
        this.atrTelefono = atrTelefono;
    }
    
    
}
