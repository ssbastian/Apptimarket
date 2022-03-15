
package co.unicauca.apptimarket.server.domain.services;

import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Utilities;
import co.unicauca.apptimarket.server.access.IAdministradorRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public class clsAdministradorService 
{
    IAdministradorRepository atrRepositorio;
    
    public clsAdministradorService(IAdministradorRepository prmRepositorio) 
    {
        atrRepositorio = prmRepositorio;
    }
    
    public synchronized clsAdministrador findAdministrador(String prmID) {
        System.out.println("Invocando findAdministrador desde admini Service");
        return atrRepositorio.findAdministrador(prmID);
    }
    
    public synchronized String createAdministrador(clsAdministrador prmAdministrador) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (prmAdministrador.getNombre().isEmpty() || prmAdministrador.getID().isEmpty()
                || prmAdministrador.getCodigo().isEmpty() || prmAdministrador.getNumeroContacto().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "ID, nombre, código y número de contacto son obligatorios "));
        }

        if (!Utilities.isNumeric(prmAdministrador.getID())) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El ID debe ser numérico. "));

        }
        
        if (!Utilities.isNumeric(prmAdministrador.getCodigo())) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El Código debe ser numérico. "));

        }
        // Que no esté repetido

        clsAdministrador administradorSearched = this.findAdministrador(prmAdministrador.getID());
        if (administradorSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El ID ya existe. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return atrRepositorio.createAdministrador(prmAdministrador);
    }
    
    public synchronized List<clsAdministrador> findAdministradores() {
       return atrRepositorio.findAdministradores();

    }
}
