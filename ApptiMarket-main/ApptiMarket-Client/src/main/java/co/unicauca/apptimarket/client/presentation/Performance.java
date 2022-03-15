/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.apptimarket.client.presentation;

import co.unicauca.apptimarket.client.access.Factory;
import co.unicauca.apptimarket.client.domain.services.ProductService;
import static co.unicauca.apptimarket.client.infra.Messages.successMessage;
import co.unicauca.apptimarket.commons.domain.Product;
import java.util.Scanner;
import co.unicauca.apptimarket.client.access.IProductAccess;

/**
 *
 * @author ahurtado
 */
public class Performance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        IProductAccess service = Factory.getInstance().getProductService();
        // Inyecta la dependencia
        ProductService productService = new ProductService(service);
        try {
            Product producto;
            for (int i=1; i<2 ; i++){
               producto = productService.findProduct("9800000"+i);
               System.out.println(producto.getAtrNombre());
        }
            
           
        } catch (Exception ex) {
           
        }
        
    }
    
}
