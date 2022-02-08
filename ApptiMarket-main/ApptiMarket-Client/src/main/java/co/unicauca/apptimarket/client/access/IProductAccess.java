package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.commons.domain.Product;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IProductAccess {

    /**
     * Buscar un cliente utilizando un socket
     *
     * @param code cedula del cliente
     * @return objeto cliente
     * @throws Exception error al buscar un cliente
     */
    public Product findProduct(String code) throws Exception;

    /**
     * Crea un Customer
     *
     * @param product cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */

    public String createProduct(Product product) throws Exception;
}
