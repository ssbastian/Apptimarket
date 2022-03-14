package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Product;
import co.unicauca.apptimarket.commons.domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de ICustomerRepository. Utilliza arreglos en memoria
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public final class ProductRepositoryImplArrays implements IProductRepository {

    /**
     * Array List de clientes
     */
    private static List<Product> ListProducts;
    private static List<User> ListUsers;

    public ProductRepositoryImplArrays() {
        if (ListProducts == null) {
            ListProducts = new ArrayList();
        }

        if (ListProducts.size() == 0) {
            inicializar();
        }
    }

    public void inicializar() {
        ListProducts.add(new Product("666", "Marco flexible", 25000, 10, "marcos"));
        ListProducts.add(new Product("11", "Lentes UV", 100.0, 50000, "Lentes"));
        ListProducts.add(new Product("12", "Marco madera", 20.0, 20000, "marcos"));
        ListProducts.add(new Product("13", "Lentes rosa", 40, 25000, "Lentes"));
        ListProducts.add(new Product("14", "Solución limpieza", 20000, 15, "Líquidos"));
        ListProducts.add(new Product("15", "Marco flexible", 25000, 10, "marcos"));
        ListProducts.add(new Product("16", "Lentes focales", 50000, 10, "Lentes"));
        ListProducts.add(new Product("17", "Estuche plastico", 5000, 20, "Accesorios"));
        ListProducts.add(new Product("18", "Tela microfibra", 55000, 15, "Accesorios"));
        ListProducts.add(new Product("19", "Lente contacto", 80000, 15, "Lentes"));
        ListProducts.add(new Product("20", "Marco ultradurable", 70000, 30, "Lentes"));
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

    /**
     * Busca u Product en el arreglo
     *
     * @param code cedula del customer
     * @return objeto Product
     */
    @Override
    public Product findProduct(String code) {
        for (Product customer : ListProducts) {
            if (customer.getAtrCodigoProducto().equals(code)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * metodo para mostrar la lista de productos en el cliente
     *
     * @return
     */
    @Override
    public List<Product> findProducts() {
        return ListProducts;
    }

    @Override
    public String createProduct(Product product) {
        ListProducts.add(product);
        return product.getAtrCodigoProducto();
    }

    
}
