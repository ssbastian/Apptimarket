/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.apptimarket.server.infra;

import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketMultiThread;
import co.unicauca.apptimarket.server.access.ProductRepositoryImplArrays;
import co.unicauca.apptimarket.server.domain.services.ProductService;

/**
 *
 * @author ahurtado
 */
public class ApptiMarketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocketMultiThread myServer = new ServerSocketMultiThread(5000);
        ApptiMarketHandler myHandler = new ApptiMarketHandler();
        myHandler.setService(new ProductService(new ProductRepositoryImplArrays()) );
        myServer.setServerHandler(myHandler);
        myServer.startServer();
    }
    
}
