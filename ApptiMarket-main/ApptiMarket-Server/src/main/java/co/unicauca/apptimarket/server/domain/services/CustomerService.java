package co.unicauca.apptimarket.server.domain.services;

import co.unicauca.apptimarket.commons.domain.Customer;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Utilities;
import co.unicauca.apptimarket.server.access.ICustomerRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan sebastian
 */
public class CustomerService {

    /**
     * repositorio de clientes
     */
    ICustomerRepository repo;

    /**
     * constructor parametrizado. hace inyeccion de dependencias
     *
     * @param repo
     */
    public CustomerService(ICustomerRepository repo) {
        this.repo = repo;
    }

    /**
     *
     * @param code codigo de un cliente dentro de la aplicacion
     * @return objeto de tipo Customer
     */
    public synchronized Customer findCustomer(String code) {
        return repo.findClient(code);
    }
    
    
    /**
     * crea un nuevo cliente. se hacen validaciones para que todos los campos sea obligatorio llenarlos
     * @param customer
     * @return 
     */
    public synchronized String createCustomer(Customer customer) {
        List<JsonError> errors = new ArrayList<>();

        //validar datos que estan vacios
        if (customer.getCodigoCustomer().isEmpty() || customer.getID().isEmpty()
                || customer.getTipoIdCustomer().isEmpty() || customer.getNombre().isEmpty()
                || customer.getNumeroContacto().isEmpty() || customer.getEmailCustomer().isEmpty()
                || customer.getDireccionCustomer().isEmpty() || customer.getDireccionCustomer().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "todos los datos correspondientes al cliente, son obligatorios. "));
        }
        
        if (!Utilities.isNumeric(customer.getCodigoCustomer())) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El código debe ser numérico. "));
        }

        //validar que no este repetido
        Customer customerSearched = this.findCustomer(customer.getCodigoCustomer());
        if (customerSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El código ya existe con otro cliente. "));
        }
        
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createClient(customer);
    }
    
    /**
     * lista de clientes
     */
    
    //TODO implementar
}
