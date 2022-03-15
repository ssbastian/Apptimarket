package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.commons.infra.Protocol;
import co.unicauca.apptimarket.commons.domain.Product;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.client.infra.ApptiMarketSocket;
import co.unicauca.apptimarket.commons.domain.ListaProductos;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Cliente. Permite hacer el CRUD de clientes solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class ApptiMarketAccessImplSockets implements IProductAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private final ApptiMarketSocket mySocket;

    public ApptiMarketAccessImplSockets() {
        mySocket = new ApptiMarketSocket();
    }

    /**
     * Busca un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param code cedula del cliente
     * @return Objeto Customer
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Product findProduct(String code) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindProductRequestJson(code);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

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
                Product product = jsonToProduct(jsonResponse);
                Logger.getLogger(ApptiMarketAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                return product;
            }
        }

    }

    /**
     * Crea un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param product cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */
    @Override
    public String createProduct(Product product) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateProductRequestJson(product);
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
                return product.getAtrCodigoProducto();
            }

        }

    }

    /**
     * Extra los mensajes de la lista de errores
     *
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idCustomer identificación del cliente
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"customer","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String doFindProductRequestJson(String code) {

        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("get");
        protocol.addParameter("code", code);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doFindListProductRequestJson() {

        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("get/lista");
        protocol.addParameter("code", "0");

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del customer para ser enviado por el
     * socket
     *
     * @param customer objeto customer
     * @return devulve algo como:
     * {"resource":"customer","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String doCreateProductRequestJson(Product product) {

        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("post");
        protocol.addParameter("Code", product.getAtrCodigoProducto());
        protocol.addParameter("Name", product.getAtrNombre());
        protocol.addParameter("Price", product.getAtrPrecio() + "");
        protocol.addParameter("Existents", product.getAtrExistencia() + "");
        protocol.addParameter("Type", product.getAtrTipo());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    /**
     * Convierte jsonCustomer, proveniente del server socket, de json a un
     * objeto Customer
     *
     * @param jsonCustomer objeto cliente en formato json
     */
    private Product jsonToProduct(String jsonProduct) {

        Gson gson = new Gson();
        Product product = gson.fromJson(jsonProduct, Product.class);
        return product;

    }
    
       private ListaProductos jsonToListProduct(String jsonProduct) {

        Gson gson = new Gson();
        //Product product = gson.fromJson(jsonProduct, Product.class);
        ListaProductos product = gson.fromJson(jsonProduct, ListaProductos.class);
        return product;

    }
    

    @Override
    public List<Product> findProducts() throws Exception {
        String jsonResponse = null;
        String requestJson = doFindListProductRequestJson();
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

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
                ListaProductos produc = jsonToListProduct(jsonResponse);
                Logger.getLogger(ApptiMarketAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                List <Product> product = produc.getListaProductos();
                return product;
            }
        }

    }

}
