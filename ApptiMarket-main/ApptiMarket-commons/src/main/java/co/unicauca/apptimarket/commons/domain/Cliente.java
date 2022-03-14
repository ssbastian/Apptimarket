package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public class Cliente {  // HACER INTERFACE Y LUEGO HACER 3 CLASES QUE PARTAN DE ELLA

    private String atrCodigoPerson;
    private String atrNombrePerson;
    private String atrEmailPersona;
    private int atrTipo;   // 0 = administrador,  1 = cliente 2 = repartidor

    public Cliente(String atrCodigoPerson, String atrNombrePerson, String atrEmailPersona, int atrTipo) {
        this.atrCodigoPerson = atrCodigoPerson;
        this.atrNombrePerson = atrNombrePerson;
        this.atrEmailPersona = atrEmailPersona;
        this.atrTipo = atrTipo;
    }

    public String getAtrCodigoPerson() {
        return atrCodigoPerson;
    }

    public void setAtrCodigoPerson(String atrCodigoPerson) {
        this.atrCodigoPerson = atrCodigoPerson;
    }

    public String getAtrNombrePerson() {
        return atrNombrePerson;
    }

    public void setAtrNombrePerson(String atrNombrePerson) {
        this.atrNombrePerson = atrNombrePerson;
    }

    public String getAtrEmailPersona() {
        return atrEmailPersona;
    }

    public void setAtrEmailPersona(String atrEmailPersona) {
        this.atrEmailPersona = atrEmailPersona;
    }

    public int getAtrTipo() {
        return atrTipo;
    }

    public void setAtrTipo(int atrTipo) {
        this.atrTipo = atrTipo;
    }

}
