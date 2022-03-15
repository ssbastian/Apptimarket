package co.unicauca.apptimarket.server.infra;

import co.unicauca.apptimarket.commons.domain.Customer;
import co.unicauca.apptimarket.commons.domain.ListaProductos;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import co.unicauca.apptimarket.commons.domain.Product;
import co.unicauca.apptimarket.commons.domain.clsAdministrador;
import co.unicauca.apptimarket.commons.domain.clsListaAdministradores;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Protocol;
import co.unicauca.apptimarket.commons.infra.Utilities;
import co.unicauca.apptimarket.server.access.Factory;
import co.unicauca.apptimarket.server.access.IAdministradorRepository;
import co.unicauca.apptimarket.server.access.ICustomerRepository;
import co.unicauca.apptimarket.server.domain.services.ProductService;
import com.google.gson.Gson;
import java.util.ArrayList;
import co.unicauca.apptimarket.server.access.IProductRepository;
import co.unicauca.apptimarket.server.domain.services.CustomerService;
import co.unicauca.apptimarket.server.domain.services.clsAdministradorService;
import java.util.List;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Libardo, Julio
 */
public class ApptiMarketServerSocket extends ServerSocketTemplate {

    /**
     * Servicio de productos
     */
    private ProductService service;

    /**
     * Servicio de Administradores
     */
    private clsAdministradorService serviceAdmin;

    /**
     * Servicio de Customers
     */
    private CustomerService serviceCustomer;

    /**
     * Constructor
     */
    public ApptiMarketServerSocket() {

    }

    /**
     * Inicialización
     *
     * @return este mismo objeto
     */
    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        // Se hace la inyección de dependencia al ProductService
        IProductRepository repository = Factory.getInstance().getRepository();
        this.setService(new ProductService(repository));

        //:V
        IAdministradorRepository repository2 = Factory.getInstance().getRepositoryAdministrador();
        this.setServiceAdmin(new clsAdministradorService(repository2));

        ICustomerRepository repository3 = Factory.getInstance().getRepositoryCustomer();
        this.setServiceCustomer(new CustomerService(repository3));
        return this;

    }

    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    @Override
    protected void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        System.out.println("PETICION__" + requestJson);
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);
        switch (protocolRequest.getResource()) {
            case "product":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetCustomer(protocolRequest);
                }

                if (protocolRequest.getAction().equals("get/lista")) {
                    // Consultar un customer
                    processGetListaCustomer(protocolRequest);
                }
                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostCustomer(protocolRequest);

                }

                break;

            case "administrador":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetAdmin(protocolRequest);
                }

                if (protocolRequest.getAction().equals("get/lista")) {
                    // Consultar un customer
                    processGetListaAdmin(protocolRequest);
                }
                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostAdmin(protocolRequest);
                }

                break;

            case "customer":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetClient(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostClient(protocolRequest);
                }

                break;
        }

    }

    /**
     * Procesa la solicitud de consultar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetListaCustomer(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        System.out.println("RECIBIO PETICION");
        Product customer = getService().findProduct(id);
        //List <Product> products = getService().findProducts(); 
        ListaProductos product = new ListaProductos(getService().findProducts());

        if (customer != null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(product));
        }
    }

    private void processGetCustomer(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Product customer = getService().findProduct(id);
        if (customer == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            List<Product> a = getService().findProducts();
            for (Product custo : a) {
                System.out.println("datos" + a.toString());
            }
            ListaProductos product = new ListaProductos(a);
            System.out.println("HHH" + product);
            respond(objectToJSON(customer));
        }
    }

    /**
     * Procesa la solicitud de agregar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostCustomer(Protocol protocolRequest) {
        Product product = new Product();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        product.setAtrCodigoProducto(protocolRequest.getParameters().get(0).getValue());
        product.setAtrNombre(protocolRequest.getParameters().get(1).getValue());
        product.setAtrPrecio(Double.parseDouble(protocolRequest.getParameters().get(2).getValue()));
        product.setAtrExistencia(Integer.parseInt(protocolRequest.getParameters().get(3).getValue()));
        product.setAtrTipo(protocolRequest.getParameters().get(4).getValue());

        String response = getService().createProduct(product);
        respond(response);
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

    private void processGetAdmin(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        clsAdministrador objAdmin = getServiceAdmin().findAdministrador(id);
        //error
        if (objAdmin == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            List<clsAdministrador> objAdministradores = getServiceAdmin().findAdministradores();
            for (clsAdministrador custo : objAdministradores) {
                System.out.println("datos" + objAdministradores.toString());
            }
            clsListaAdministradores administradores = new clsListaAdministradores(objAdministradores);
            System.out.println("HHH" + administradores);
            respond(objectToJSON(objAdmin));
        }
    }

    private void processGetListaAdmin(Protocol protocolRequest) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void processPostAdmin(Protocol protocolRequest) {
        clsAdministrador objAdmin = new clsAdministrador();

        objAdmin.setNombre(protocolRequest.getParameters().get(0).getValue());
        objAdmin.setID(protocolRequest.getParameters().get(1).getValue());
        objAdmin.setCodigo(protocolRequest.getParameters().get(2).getValue());
        objAdmin.setNumeroContacto(protocolRequest.getParameters().get(3).getValue());

        String response = getServiceAdmin().createAdministrador(objAdmin);
        respond(response);
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

    /**
     * @return the service
     */
    public clsAdministradorService getServiceAdmin() {
        return serviceAdmin;
    }

    public CustomerService getServiceCustomer() {
        return serviceCustomer;
    }

    /**
     * @param service the service to set
     */
    public void setServiceAdmin(clsAdministradorService prmService) {
        serviceAdmin = prmService;
    }

    private void setServiceCustomer(CustomerService customerService) {
        serviceCustomer = customerService;
    }

    /**
     * Busqueda del cliente
     *
     * @param protocolRequest
     */
    private void processGetClient(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Customer customer = getServiceCustomer().findCustomer(id);
        if (customer == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(customer));
        }

    }

    private void processPostClient(Protocol protocolRequest) {
        Customer objCustomer = new Customer();

        objCustomer.setCodigoCustomer(protocolRequest.getParameters().get(0).getValue());
        objCustomer.setID(protocolRequest.getParameters().get(1).getValue());
        objCustomer.setTipoIdCustomer(protocolRequest.getParameters().get(2).getValue());
        objCustomer.setNombre(protocolRequest.getParameters().get(3).getValue());
        objCustomer.setNumeroContacto(protocolRequest.getParameters().get(4).getValue());
        objCustomer.setEmailCustomer(protocolRequest.getParameters().get(5).getValue());
        objCustomer.setDireccionCustomer(protocolRequest.getParameters().get(6).getValue());
        objCustomer.setGeneroCustomer(protocolRequest.getParameters().get(7).getValue());

        String response = getServiceCustomer().createCustomer(objCustomer);
        respond(response);

    }
}
