
package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.client.infra.ApptiMarketSocket;
import co.unicauca.apptimarket.commons.domain.Buy;
import co.unicauca.apptimarket.commons.domain.BuyList;
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
public class ApptiMarketAccessImplSocketsBuy implements IBuyAccess
{
    private final ApptiMarketSocket mySocket;

    public ApptiMarketAccessImplSocketsBuy() {
        mySocket = new ApptiMarketSocket();
    }

    @Override
    public String createBuy(Buy prmBuy) throws Exception 
    {
        String jsonResponse = null;
        String requestJson = doCreateBuyRequestJson(prmBuy);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return prmBuy.getCodigoCompra();
            }

        }
    }

    @Override
    public Buy findBuy(String prmCode) throws Exception 
    {
        String jsonResponse = null;
        String requestJson = doFindBuyRequestJson(prmCode);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                Buy buy = jsonToBuy(jsonResponse);
                Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                return buy;
            }
        }
    }

    @Override
    public List<Buy> findBuys() throws Exception 
    {
        String jsonResponse = null;
        String requestJson = doFindListBuyRequestJson();
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                
                //List<Product> product = (List<Product>) jsonToProduct(jsonResponse);
                BuyList produc = jsonToListBuy(jsonResponse);
                Logger.getLogger(ApptiMarketAccessImplSocketsBuy.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                List <Buy> buys = produc.getListaProductos();
                return buys;
            }
        }
    }

    private String doFindBuyRequestJson(String prmCode) {
        Protocol protocol = new Protocol();
        protocol.setResource("buy");
        protocol.setAction("get");
        protocol.addParameter("code", "0");

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    private Buy jsonToBuy(String jsonBuy) {
        Gson gson = new Gson();
        Buy product = gson.fromJson(jsonBuy, Buy.class);
        return product;
    }
    
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    private String doCreateBuyRequestJson(Buy prmBuy) 
    {
        Protocol protocol = new Protocol();
        protocol.setResource("buy");
        protocol.setAction("post");
        protocol.addParameter("Code", prmBuy.getCodigoCompra());
        protocol.addParameter("Cont", prmBuy.getNumeroCompra());
        protocol.addParameter("Total", prmBuy.getTotal());
        protocol.addParameter("Descripcion", prmBuy.getDescripcion());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doFindListBuyRequestJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("buy");
        protocol.setAction("get/lista");
        protocol.addParameter("code", "0");

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private BuyList jsonToListBuy(String jsonBuy) {
        Gson gson = new Gson();
        //Product product = gson.fromJson(jsonProduct, Product.class);
        BuyList buys = gson.fromJson(jsonBuy, BuyList.class);
        return buys;
    }
}
