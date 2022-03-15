
package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.client.infra.ApptiMarketSocket;
import co.unicauca.apptimarket.commons.domain.Cliente;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WINDOWS
 */
public class ApptiMarketAccessImplSocketsClient implements IClientAccess
{

    private final ApptiMarketSocket mySocket;
    
    public ApptiMarketAccessImplSocketsClient() 
    {
        mySocket = new ApptiMarketSocket();
    }
    
    
    @Override
    public String createProduct(Cliente prmClient) throws Exception 
    {
       String jsonResponse = null;
        String requestJson = doCreateClientRequestJson(prmClient);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

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
                return prmClient.getAtrCodigoPerson();
            }

        }
    }

    @Override
    public Cliente findProduct(String prmCode) throws Exception 
    {
       String jsonResponse = null;
        String requestJson = doFindClientRequestJson(prmCode);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ApptiMarketAccessImplSocketsClient.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(ApptiMarketAccessImplSocketsClient.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                Cliente client = jsonToClient(jsonResponse);
                Logger.getLogger(ApptiMarketAccessImplSocketsClient.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                return client;
            }
        }
    }

    private String doFindClientRequestJson(String prmCode) 
    {
        Protocol protocol = new Protocol();
        protocol.setResource("client");
        protocol.setAction("get");
        protocol.addParameter("code", prmCode);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String extractMessages(String jsonResponse) 
    {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    private JsonError[] jsonToErrors(String jsonError) 
    {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    private Cliente jsonToClient(String jsonProduct) 
    {
        Gson gson = new Gson();
        Cliente client = gson.fromJson(jsonProduct, Cliente.class);
        return client;
    }

    private String doCreateClientRequestJson(Cliente prmClient) 
    {
        Protocol protocol = new Protocol();
        protocol.setResource("client");
        protocol.setAction("post");
        protocol.addParameter("Code", prmClient.getAtrCodigoPerson());
        protocol.addParameter("Name", prmClient.getAtrNombrePerson());
        protocol.addParameter("Email", prmClient.getAtrEmailPersona());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }
    
}
