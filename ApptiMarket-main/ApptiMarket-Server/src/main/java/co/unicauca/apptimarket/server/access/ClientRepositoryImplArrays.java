
package co.unicauca.apptimarket.server.access;

import com.mysql.cj.xdevapi.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public class ClientRepositoryImplArrays 
{/**
     * Array List de clientes
     */
    private static List<Client> ListClient;

    public ClientRepositoryImplArrays() {
        if (ListClient == null) {
            ListClient = new ArrayList();
        }

        if (ListClient.size() == 0) {
            inicializar();
        }
    }
    
    public void inicializar()
    {
        
    }
}
