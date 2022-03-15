
package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.commons.domain.Cliente;



/**
 *
 * @author WINDOWS
 */
public interface IClientAccess 
{
    public String createProduct(Cliente prmClient) throws Exception;
    
    public Cliente findProduct(String prmCode) throws Exception;
}
