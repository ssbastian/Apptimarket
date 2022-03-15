package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public final class Customer extends clsCliente {  // HACER INTERFACE Y LUEGO HACER 3 CLASES QUE PARTAN DE ELLA

    private String atrCodigoCustomer; //codigo de la persona en la aplicacion, diferente a identificacion.
    private String atrEmailCustomer;
    private String atrDireccionCustomer;
    private String atrTipoIdCustomer; //cc, ti
    private String atrGeneroCustomer;

    public Customer(String prmCodigoPerson, String prmId, String prmTipoId, String prmNombre,
            String prmNumeroContacto, String prmEmailPersona, String prmDireccion, String prmGenero) {
        super(prmNombre, prmId, prmNumeroContacto);
        atrDireccionCustomer = prmDireccion;
        atrCodigoCustomer = prmCodigoPerson;
        atrEmailCustomer = prmEmailPersona;
        atrTipoIdCustomer = prmTipoId;
        atrGeneroCustomer = prmGenero;
    }

    public Customer() {
    }

    
    
    @Override
    public String description() {
        return "Módulo para la creación de un cliente";
    }

    public String getAtrCodigoCustomer() {
        return atrCodigoCustomer;
    }

    public void setAtrCodigoCustomer(String atrCodigoCustomer) {
        this.atrCodigoCustomer = atrCodigoCustomer;
    }

    public String getAtrEmailCustomer() {
        return atrEmailCustomer;
    }

    public void setAtrEmailCustomer(String atrEmailCustomer) {
        this.atrEmailCustomer = atrEmailCustomer;
    }

    public String getAtrDireccionCustomer() {
        return atrDireccionCustomer;
    }

    public void setAtrDireccionCustomer(String atrDireccionCustomer) {
        this.atrDireccionCustomer = atrDireccionCustomer;
    }

   
    public String getAtrTipoIdCustomer() {
        return atrTipoIdCustomer;
    }

    public void setAtrTipoIdCustomer(String atrTipoIdCustomer) {
        this.atrTipoIdCustomer = atrTipoIdCustomer;
    }

    public String getAtrGeneroCustomer() {
        return atrGeneroCustomer;
    }

    public void setAtrGeneroCustomer(String atrGeneroCustomer) {
        this.atrGeneroCustomer = atrGeneroCustomer;
    }

}
