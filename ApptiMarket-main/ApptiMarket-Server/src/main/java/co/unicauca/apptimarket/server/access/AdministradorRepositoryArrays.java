
package co.unicauca.apptimarket.server.access;


import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public class AdministradorRepositoryArrays implements IAdministradorRepository 
{

    private static List<clsAdministrador> atrAdministradores;

    public AdministradorRepositoryArrays() {
        if (atrAdministradores == null) {
            atrAdministradores = new ArrayList();
        }

        if (atrAdministradores.size() == 0) {
            inicializar();
        }
    }
    
    public void inicializar()
    {
        atrAdministradores.add(new clsAdministrador("Ana Mendoza", "10", "1010", "3165874510"));
        atrAdministradores.add(new clsAdministrador("Paulo Díaz", "11", "1111", "3206571456"));

    }
    
    @Override
    public clsAdministrador findAdministrador(String prmID) 
    {
        System.out.println("invocando findAdministrador");
        for (clsAdministrador customer : atrAdministradores) 
        {
            if (customer.getID().equals(prmID)) 
            {
                return customer;
            }
        }
        return null;
    }

    @Override
    public String createAdministrador(clsAdministrador prmAdministrador) 
    {
        atrAdministradores.add(prmAdministrador);
        return prmAdministrador.getID();
    }

    @Override
    public List<clsAdministrador> findAdministradores() 
    {
        return atrAdministradores;
    }
    
}
