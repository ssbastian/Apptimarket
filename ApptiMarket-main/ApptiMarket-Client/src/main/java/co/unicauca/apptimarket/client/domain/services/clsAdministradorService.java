
package co.unicauca.apptimarket.client.domain.services;

import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import java.util.List;
import co.unicauca.apptimarket.client.access.IAdministradorAccess;

/**
 *
 * @author WINDOWS
 */
public class clsAdministradorService 
{
    private final IAdministradorAccess atrAccess;
    
    public clsAdministradorService(IAdministradorAccess prmAccess) {
        atrAccess = prmAccess;
    }
    
    public clsAdministrador findAdministrador(String code) throws Exception {
        return atrAccess.buscarAdministrador(code);

    }
    
    public List<clsAdministrador> findAdministradores() throws Exception {
        return atrAccess.desplegarAministradores();

    }
    public String createAdministrador(clsAdministrador product) throws Exception {
        return atrAccess.crearAdministrador(product);

    }    
}
