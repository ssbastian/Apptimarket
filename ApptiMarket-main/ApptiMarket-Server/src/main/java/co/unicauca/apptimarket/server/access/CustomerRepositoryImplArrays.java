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
        if (ListCustomers.size() == 0){ 
            initArray();
        }
    }

    @Override
    public Customer findClient(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createClient(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * cargar clientes en el sistema
     */
    private void initArray() {
     
        
        
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


