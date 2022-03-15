
package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public interface IAdministradorAccess 
{
    public abstract clsAdministrador buscarAdministrador(String prmID) throws Exception;;
    
    public abstract List <clsAdministrador> desplegarAministradores() throws Exception;;
    
    public abstract String crearAdministrador(clsAdministrador prmAdministrador) throws Exception;;
}
