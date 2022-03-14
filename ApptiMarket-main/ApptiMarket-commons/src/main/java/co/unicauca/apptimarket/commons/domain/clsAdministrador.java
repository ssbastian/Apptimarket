package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author WINDOWS
 */
public class clsAdministrador extends clsCliente {

    private String atrCodigo;

    public clsAdministrador() {
    }

    public clsAdministrador(String prmNombre, String prmID, String prmNumeroContacto, String prmCodigo) {
        super(prmNombre, prmID, prmNumeroContacto);
        atrCodigo = prmCodigo;
    }

    public String getCodigo() {
        return atrCodigo;
    }

    public void setCodigo(String prmCodigo) {
        atrCodigo = prmCodigo;
    }

    @Override
    public String description() {
        return "Módulo para la creación de un administrador";
    }

    @Override
    public String toString() {
        return "clsAdministrador{" + "atrCodigo=" + atrCodigo + '}';
    }

 
    
    

}
