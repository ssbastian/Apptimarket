package co.unicauca.apptimarket.server.app;

import co.unicauca.apptimarket.server.infra.ApptiMarketServerSocket;



/**
 * Aplicación principal que lanza el servidor en un hilo
 * @author Libardo, Julio
 */
public class AgenciaViajesApplication {
    public static void main(String args[]){
        ApptiMarketServerSocket server = new ApptiMarketServerSocket();
        server.startServer();
    }
}
