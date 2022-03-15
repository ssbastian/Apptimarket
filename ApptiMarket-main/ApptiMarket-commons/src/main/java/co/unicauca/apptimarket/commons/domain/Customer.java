package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public class Customer extends clsCliente{  // HACER INTERFACE Y LUEGO HACER 3 CLASES QUE PARTAN DE ELLA

    private String atrCodigoPerson; //codigo de la persona en la aplicacion, diferente a identificacion.
    private String atrEmailPersona;
    private String atrDireccion;
    private int atrTipo;   

    public Customer(String prmCodigoPerson, String prmId, String prmNombre, String prmNumeroContacto, String prmEmailPersona, String prmDireccion, int prmTipo) {
        super(prmNombre, prmId, prmNumeroContacto);
        atrDireccion = prmDireccion;
        atrCodigoPerson = prmCodigoPerson;
        atrEmailPersona = prmEmailPersona;
        atrTipo = prmTipo;
    }

    @Override
    public String description() {
         return "Módulo para la creación de un cliente";
    }
   
}
