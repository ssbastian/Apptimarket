package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Product;
import java.util.List;

/**
 * Interface del respositorio de clientes
 * @author Libardo Pantoja
 */
public interface IProductRepository {
    /**
     * Busca un Product por su id
     * @param code id del producto
     * @return  objeto de tipo Product
     */
    
    public Product findProduct(String code);
    public String createProduct(Product product);
    public List<Product> findProducts();  //retornar lista de productos

}
