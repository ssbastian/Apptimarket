package co.unicauca.apptimarket.client.domain.services;

import co.unicauca.apptimarket.commons.domain.Product;
import co.unicauca.apptimarket.client.access.IProductAccess;
import java.util.List;


/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class ProductService {

    private final IProductAccess access;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param access
     */
    public ProductService(IProductAccess access) {
        this.access = access;
    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param code
     * @return Objeto tipo Cliente, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Product findProduct(String code) throws Exception {
        return access.findProduct(code);

    }
    
    
    
     public List<Product> findProducts() throws Exception {
        return access.findProducts();

    }
    public String createProduct(Product product) throws Exception {
        return access.createProduct(product);

    }    

}
