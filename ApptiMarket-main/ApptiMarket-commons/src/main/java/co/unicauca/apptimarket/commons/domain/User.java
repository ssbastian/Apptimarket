package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author juan sebastian
 */
public class User {

    private String atrCodigoUser;
    private String atrNombreUser;
    private int tipoUser; //0 , 1 , 2
    private int emailUser;
    private String celularUser;
    private String generoUser;

    public User(String atrCodigoUser, String atrNombreUser, int tipoUser, int emailUser, String celularUser, String generoUser) {
        this.atrCodigoUser = atrCodigoUser;
        this.atrNombreUser = atrNombreUser;
        this.tipoUser = tipoUser;
        this.emailUser = emailUser;
        this.celularUser = celularUser;
        this.generoUser = generoUser;
    }

    public User() {
    }
        

    public String getAtrCodigoUser() {
        return atrCodigoUser;
    }

    public void setAtrCodigoUser(String atrCodigoUser) {
        this.atrCodigoUser = atrCodigoUser;
    }

    public String getAtrNombreUser() {
        return atrNombreUser;
    }

    public void setAtrNombreUser(String atrNombreUser) {
        this.atrNombreUser = atrNombreUser;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    public int getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(int emailUser) {
        this.emailUser = emailUser;
    }

    public String getCelularUser() {
        return celularUser;
    }

    public void setCelularUser(String celularUser) {
        this.celularUser = celularUser;
    }

    public String getGeneroUser() {
        return generoUser;
    }

    public void setGeneroUser(String generoUser) {
        this.generoUser = generoUser;
    }
    
}