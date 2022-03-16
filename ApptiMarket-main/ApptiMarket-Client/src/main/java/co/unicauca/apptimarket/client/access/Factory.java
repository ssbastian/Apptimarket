package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar CustomerServiceImplSockets o cualquier
 * otro que se cree en el futuro.
 *
 * @author Libardo, Julio
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICustomerService
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IProductAccess getProductService() {

        IProductAccess result = null;
        String type = Utilities.loadProperty("product.service");

        switch (type) {
            case "default":
                result = new ApptiMarketAccessImplSockets();
                break;
        }

        return result;

    }
    
    public IAdministradorAccess getAdministradorService()
    {
        IAdministradorAccess cmpResult = null;
        
        //String cmpType = Utilities.loadProperty("administrador.service");
        String cmpType = "default";
        switch(cmpType)
        {
            case "default":
                cmpResult = new clsApptiMarketAccessImplSocketsAdmi();
                break;
        }
        
        return cmpResult;
    }
    
    public IBuyAccess getBuyService()
    {
        IBuyAccess cmpResult = null;
        
        //String cmpType = Utilities.loadProperty("administrador.service");
        String cmpType = "default";
        switch(cmpType)
        {
            case "default":
                cmpResult = new ApptiMarketAccessImplSocketsBuy();
                break;
        }
        
        return cmpResult;
    }
}
