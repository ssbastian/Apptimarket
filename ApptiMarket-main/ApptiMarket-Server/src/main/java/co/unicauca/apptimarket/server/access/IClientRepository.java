
package co.unicauca.apptimarket.server.access;

import com.mysql.cj.xdevapi.Client;

/**
 *
 * @author WINDOWS
 */
public interface IClientRepository 
{
    public Client findAdministrador(String prmID);
    public String createAdministrador(Client prmClient);
}
