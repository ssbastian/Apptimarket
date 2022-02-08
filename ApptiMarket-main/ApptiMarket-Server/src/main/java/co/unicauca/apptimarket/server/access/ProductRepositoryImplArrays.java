package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Product;
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
    private static List<Product> products;

    public ProductRepositoryImplArrays() {
        if (products == null){
            products = new ArrayList();
        }
        
        if (products.size() == 0){
            inicializar();
        }
    }

    public void inicializar() 
    {
        
        products.add(new Product("11", "Lentes UV", 100.0, 50, "Lentes"));
        products.add(new Product("12", "Marco madera", 20.0, 20, "marcos"));
        products.add(new Product("13", "Lentes rosa", 40, 25, "Lentes"));
        products.add(new Product("14", "Solución limpieza", 20, 15, "Líquidos"));
        products.add(new Product("15", "Marco flexible", 25.0, 10, "marcos"));
        products.add(new Product("16", "Lentes focales", 50, 10, "Lentes"));
        products.add(new Product("17", "Estuche plastico", 5.0, 20, "Accesorios"));
        products.add(new Product("18", "Tela microfibra", 55.0, 15, "Accesorios"));
        products.add(new Product("19", "Lente contacto", 80.0, 15, "Lentes"));
        products.add(new Product("20", "Marco ultradurable", 70.0, 30, "Lentes"));
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
        for (Product customer : products) {
            if (customer.getAtrCodigoProducto().equals(code)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public String createProduct(Product product) {
        products.add(product);
        return product.getAtrCodigoProducto();
    }

}
