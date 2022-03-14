
package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.client.infra.ApptiMarketSocket;
import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import co.unicauca.apptimarket.commons.domain.clsListaAdministradores;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WINDOWS
 */
public class clsApptiMarketAccessImplSocketsAdmi implements IAdministradorAccess
{
    private final ApptiMarketSocket objClienteSocket; 
    
    
    public clsApptiMarketAccessImplSocketsAdmi()
    {
        objClienteSocket = new ApptiMarketSocket();
    }
    
    @Override
    public clsAdministrador buscarAdministrador(String prmID) throws Exception
    {
        String jsonResponse = null;
        String requestJson = doFindAdministradorRequestJson(prmID);
        System.out.println(requestJson);
            
        try 
        {
            objClienteSocket.connect();
            jsonResponse = objClienteSocket.sendRequest(requestJson);
            objClienteSocket.disconnect();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(clsApptiMarketAccessImplSocketsAdmi.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(clsApptiMarketAccessImplSocketsAdmi.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                clsAdministrador objCliente = jsonToClient(jsonResponse);
                Logger.getLogger(clsApptiMarketAccessImplSocketsAdmi.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                return objCliente;
            }
        }
    }

    @Override
    public List<clsAdministrador> desplegarAministradores() throws Exception
    {
         String jsonResponse = null;
        String requestJson = doFindListAdministradoresRequestJson();
        System.out.println(requestJson);
        try {
            objClienteSocket.connect();
            jsonResponse = objClienteSocket.sendRequest(requestJson);
            objClienteSocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ApptiMarketAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(ApptiMarketAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                
                //List<Product> product = (List<Product>) jsonToProduct(jsonResponse);
                clsListaAdministradores objAdministradores = jsonToListAdministradores(jsonResponse);
                Logger.getLogger(ApptiMarketAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                List <clsAdministrador> varObjAdeministradores = objAdministradores.getListaProductos();
                return varObjAdeministradores;
            }
        }
    }
    
    private String doFindListAdministradoresRequestJson() {

        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("get/lista");
        protocol.addParameter("ID", "0");

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    
    private clsListaAdministradores jsonToListAdministradores(String jsonProduct) {

        Gson gson = new Gson();
        //Product product = gson.fromJson(jsonProduct, Product.class);
        clsListaAdministradores objAdministradores = gson.fromJson(jsonProduct, clsListaAdministradores.class);
        return objAdministradores;

    }

    @Override
    public String crearAdministrador(clsAdministrador prmAdministrador) throws Exception
    {
        String jsonResponse = null;
        String requestJson = doCreateAdministradorRequestJson(prmAdministrador);
        try {
            objClienteSocket.connect();
            jsonResponse = objClienteSocket.sendRequest(requestJson);
            objClienteSocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ApptiMarketAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(ApptiMarketAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return prmAdministrador.getID();
            }

        }
    }
    
    
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }
    
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }
    
    private String doFindAdministradorRequestJson(String prmID) {

        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("get");
        protocol.addParameter("ID", prmID);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    
    private clsAdministrador jsonToClient(String jsonProduct) {

        Gson gson = new Gson();
        clsAdministrador objCliente = gson.fromJson(jsonProduct, clsAdministrador.class);
        return objCliente;

    }
    
    
    private String doCreateAdministradorRequestJson(clsAdministrador prmAdministrador) {

        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("post");
        protocol.addParameter("Name", prmAdministrador.getNombre());
        protocol.addParameter("ID", prmAdministrador.getID());   
        protocol.addParameter("Number Contact", prmAdministrador.getNumeroContacto()+ "");
        protocol.addParameter("Code", prmAdministrador.getCodigo());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }
}
