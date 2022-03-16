/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.apptimarket.server.infra;

import co.unicauca.apptimarket.commons.domain.Buy;
import co.unicauca.serversocket.serversockettemplate.infra.ServerHandler;
import co.unicauca.apptimarket.commons.domain.Product;
import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Protocol;
import co.unicauca.apptimarket.server.domain.services.BuyService;
import co.unicauca.apptimarket.server.domain.services.ProductService;
import co.unicauca.apptimarket.server.domain.services.clsAdministradorService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahurtado
 */
public class ApptiMarketHandler extends ServerHandler {

     /**
     * Servicio de clientes
     */
    private static ProductService service;
    private static clsAdministradorService atrServiceAdministrador;
    private static BuyService serviceBuy;
    
     /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
   
    
    @Override
    public void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "product":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetProduct(protocolRequest);
                }
                
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetProduct(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostProduct(protocolRequest);
                }
                break;
            case "administrador":
                if(protocolRequest.getAction().equals("get"))
                {
                    processGetAdministrador(protocolRequest);
                }
                
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetAdministrador(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostAdministrador(protocolRequest);
                }
                break;
            case "buy":
                if(protocolRequest.getAction().equals("get"))
                {
                    processGetBuy(protocolRequest);
                }
                
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetBuy(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostBuy(protocolRequest);
                }
                break;
                    
              //otro caso seria para otra tabla
        }

    }

    /**
     * Procesa la solicitud de consultar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetProduct(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String code = protocolRequest.getParameters().get(0).getValue();
        Product product = service.findProduct(code);
        List<Product> ListProducts = service.findProducts();
        if (product == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(product));
        }
    }
    
    
//        private void processGetProduct(Protocol protocolRequest) {
//        // Extraer la cedula del primer parámetro
//        String code = protocolRequest.getParameters().get(0).getValue();
//        Product product = service.findProduct(code);
//        if (product == null) {
//            String errorJson = generateNotFoundErrorJson();
//            respond(errorJson);
//        } else {
//            respond(objectToJSON(product));
//        }
//    }


    /**
     * Procesa la solicitud de agregar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostProduct(Protocol protocolRequest) {
        Product product = new Product();
        // Reconstruir el product a partid de lo que viene en los parámetros
        
        product.setAtrCodigoProducto(protocolRequest.getParameters().get(0).getValue());
        product.setAtrNombre(protocolRequest.getParameters().get(1).getValue());
        product.setAtrPrecio(Double.parseDouble(protocolRequest.getParameters().get(2).getValue()));
        product.setAtrExistencia(Integer.parseInt( protocolRequest.getParameters().get(3).getValue()));
        product.setAtrTipo(protocolRequest.getParameters().get(4).getValue());

        String response = getService().createProduct(product);
        respond(response);
    }

    private void processPostAdministrador(Protocol protocolRequest)
    {
        clsAdministrador objAdministrador = new clsAdministrador();
        
        objAdministrador.setNombre(protocolRequest.getParameters().get(0).getValue());
        objAdministrador.setID(protocolRequest.getParameters().get(1).getValue());
        objAdministrador.setCodigo(protocolRequest.getParameters().get(2).getValue());
        objAdministrador.setNumeroContacto(protocolRequest.getParameters().get(3).getValue());

        String response = getServiceAdministrador().createAdministrador(objAdministrador);
        respond(response);
    }
    
    private void processGetAdministrador(Protocol protocolRequest)
    {
        String cmpID = protocolRequest.getParameters().get(0).getValue();
        clsAdministrador objAdministrador = atrServiceAdministrador.findAdministrador(cmpID);
        List<clsAdministrador> varObjAdministradores = atrServiceAdministrador.findAdministradores();
        if (objAdministrador == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(objAdministrador));
        }
    }
    
    
    
    /**
     * Genera un ErrorJson de cliente no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Producto no encontrado. Código no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

    /**
     * @return the service
     */
    public ProductService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(ProductService service) {
        this.service = service;
    } 
    
    public clsAdministradorService getServiceAdministrador() {
        return atrServiceAdministrador;
    }

    public void setServiceAdministrador(clsAdministradorService prmService) {
        atrServiceAdministrador = prmService;
    }

    public BuyService getServiceBuy()
    {
        return serviceBuy;
    }
    
    public void setServiceBuy(BuyService prmServiceBuy)
    {
        serviceBuy = prmServiceBuy;
    }
    
    private void processGetBuy(Protocol protocolRequest) 
    {
        String code = protocolRequest.getParameters().get(0).getValue();
        Buy buy = serviceBuy.findBuy(code);
        List<Buy> ListBuys = serviceBuy.findBuys();
        if (buy == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(buy));
        }
    }

    private void processPostBuy(Protocol protocolRequest) {
        Buy buy = new Buy();
       
        
        buy.setCodigoCompra(protocolRequest.getParameters().get(0).getValue());
        buy.setNumeroCompra(protocolRequest.getParameters().get(1).getValue());
        buy.setTotal(protocolRequest.getParameters().get(2).getValue());
        buy.setDescripcion(protocolRequest.getParameters().get(3).getValue());

        String response = getServiceBuy().createbBuy(buy);
        respond(response);
    }
}
