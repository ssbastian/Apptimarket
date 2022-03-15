package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public final class Customer extends clsCliente { 

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

    public String getCodigoCustomer() {
        return atrCodigoCustomer;
    }

    public void setCodigoCustomer(String atrCodigoCustomer) {
        this.atrCodigoCustomer = atrCodigoCustomer;
    }

    public String getEmailCustomer() {
        return atrEmailCustomer;
    }

    public void setEmailCustomer(String atrEmailCustomer) {
        this.atrEmailCustomer = atrEmailCustomer;
    }

    public String getDireccionCustomer() {
        return atrDireccionCustomer;
    }

    public void setDireccionCustomer(String atrDireccionCustomer) {
        this.atrDireccionCustomer = atrDireccionCustomer;
    }

   
    public String getTipoIdCustomer() {
        return atrTipoIdCustomer;
    }

    public void setTipoIdCustomer(String atrTipoIdCustomer) {
        this.atrTipoIdCustomer = atrTipoIdCustomer;
    }

    public String getGeneroCustomer() {
        return atrGeneroCustomer;
    }

    public void setGeneroCustomer(String atrGeneroCustomer) {
        this.atrGeneroCustomer = atrGeneroCustomer;
    }

}
