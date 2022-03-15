package co.unicauca.apptimarket.server.domain.services;

import co.unicauca.apptimarket.commons.domain.Product;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Utilities;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.unicauca.apptimarket.server.access.IProductRepository;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Libardo, Julio
 */
public class ProductService {

    /**
     * Repositorio de productos
     */
    IProductRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IProductRepository
     */
    public ProductService(IProductRepository repo) {
        this.repo = repo;
    }

    /**
     * Buscar un Producto
     *
     * @param code codigo en la aplicacion
     * @return objeto tipo Product
     */
    public synchronized Product findProduct(String code) {
        return repo.findProduct(code);
    }
    
    

    /**
     * Crea un nuevo customer. Aplica validaciones de negocio
     *
     * @param product producto
     * @return devuelve la cedula del customer creado
     */
    public synchronized String createProduct(Product product) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (product.getAtrCodigoProducto().isEmpty() || product.getAtrNombre().isEmpty()
                || product.getAtrTipo().isEmpty() || product.getAtrPrecio() <= 0.0) {
            errors.add(new JsonError("400", "BAD_REQUEST", "código, nombre, precio, existencias y tipo son obligatorios. "));
        }

        if (!Utilities.isNumeric(product.getAtrCodigoProducto())) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El código debe ser numérico. "));

        }
        // Que no esté repetido

        Product productSearched = this.findProduct(product.getAtrCodigoProducto());
        if (productSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El código ya existe. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createProduct(product);
    }

    

    
    /**
     * lista de productos para retornarla al cliente
     * @return 
     */
    public synchronized List<Product> findProducts() {
       return repo.findProducts();

    }

}
