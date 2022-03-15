package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Customer;
import co.unicauca.apptimarket.commons.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan sebastian
 */
public class CustomerRepositoryImplArrays implements ICustomerRepository {

    private static List<Customer> ListCustomers;

    public CustomerRepositoryImplArrays() {
        if (ListCustomers == null) {
            ListCustomers = new ArrayList();
        }
        if (ListCustomers.size() == 0) {
            initArray();
        }
    }
    
    /**
     * m[etodo que permite encontrar un cliente
     * @param code
     * @return 
     */
    @Override
    public Customer findClient(String code) {
        for (Customer customer : ListCustomers) {
            if (customer.getAtrCodigoCustomer().equals(code)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * metodo que permite anadir un nuevo cliente a la lista
     * @param customer
     * @return 
     */
    @Override
    public String createClient(Customer customer) {
        ListCustomers.add(customer);
        return customer.getAtrCodigoCustomer();
    }

    /**
     * cargar clientes en el sistema
     */
    private void initArray() {
        ListCustomers.add(new Customer("1", "106171011", "CC", "Andrea Pantoja", "3145878752", "andrea@hotmail.com", "calle 17 la Esmeralda", "Femenino"));
        ListCustomers.add(new Customer("1", "106183187", "CC", "Gabriela Muñoz", "3155878752", "gaby@hotmail.com", "calle 5 lomas g", "Femenino"));
        ListCustomers.add(new Customer("1", "1061187", "CC", "Lionel Alvarez", "31558878752", "lionel@hotmail.com", "calle 6 centro", "Masculino"));

        /*customers.add(new Product("98000001", "Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "3145878752", "andrea@hotmail.com", "Femenino"));
        customers.add(new Product("98000002", "Libardo", "Pantoja", "Santa Barbar Popayan", "3141257845", "libardo@gmail.com", "Masculino"));
        customers.add(new Product("98000003", "Carlos", "Pantoja", "Santa Barbar Popayan", "3141257846", "carlos@gmail.com", "Masculino"));
        customers.add(new Product("98000004", "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino"));
        customers.add(new Product("98000005", "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Product("98000006", "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Product("98000007", "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Product("98000008", "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Product("98000009", "Alberto", "Mendez Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Product("98000010", "Alexander", "Ponce Yepes", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));*/
    }
}
