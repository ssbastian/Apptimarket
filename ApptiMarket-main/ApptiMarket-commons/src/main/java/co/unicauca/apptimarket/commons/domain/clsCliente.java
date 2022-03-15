package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public abstract class clsCliente {  // HACER INTERFACE Y LUEGO HACER 3 CLASES QUE PARTAN DE ELLA

    private String atrNombre;
    private String atrID; //identificacion
    private String atrNumeroContacto;
    
    public clsCliente()
    {
        
    }
    
    public clsCliente(String prmNombre, String prmID, String prmNumeroContacto)
    {
        atrNombre = prmNombre;
        atrID = prmID;
        atrNumeroContacto = prmNumeroContacto;
    }
    
    public String getNombre()
    {
        return atrNombre;
    }
    
    public String getID()
    {
        return atrID;
    }
    
    public String getNumeroContacto()
    {
        return atrNumeroContacto;
    }
    
    public void setNombre(String prmNombre)
    {
        atrNombre = prmNombre;
    }
    
    public void setID(String prmID)
    {
        atrID = prmID;
    }
    
    public void setNumeroContacto(String prmNumeroContacto)
    {
        atrNumeroContacto = prmNumeroContacto;
    }
    
    public abstract String description();
}
