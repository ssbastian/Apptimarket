package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public class Cliente {  // HACER INTERFACE Y LUEGO HACER 3 CLASES QUE PARTAN DE ELLA

    private String atrCodigoPerson;
    private String atrNombrePerson;
    private String atrEmailPersona;
  
    public Cliente(String atrCodigoPerson, String atrNombrePerson, String atrEmailPersona) {
        this.atrCodigoPerson = atrCodigoPerson;
        this.atrNombrePerson = atrNombrePerson;
        this.atrEmailPersona = atrEmailPersona;
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

}
