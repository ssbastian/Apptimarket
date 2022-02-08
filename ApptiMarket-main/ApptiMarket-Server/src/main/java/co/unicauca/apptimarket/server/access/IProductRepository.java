package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Product;

/**
 * Interface del respositorio de clientes
 * @author Libardo Pantoja
 */
public interface IProductRepository {
    /**
     * Busca un Product por su ceduka
     * @param code cedula del cliente
     * @return  objeto de tipo Product
     */
    
    public Product findProduct(String code);
    public String createProduct(Product product);

}
