
package co.unicauca.apptimarket.server.access;


import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public interface IAdministradorRepository 
{
    public clsAdministrador findAdministrador(String prmID);
    public String createAdministrador(clsAdministrador prmAdministrador);
    public List<clsAdministrador> findAdministradores();
}
