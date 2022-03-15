package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Customer;
import co.unicauca.apptimarket.commons.domain.Product;

/**
 * Interface del respositorio de clientes
 *
 * @author juan sebastian
 */
public interface ICustomerRepository {

    public Customer findClient(String code);
    public String createClient(Customer customer);
}
