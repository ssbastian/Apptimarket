# travelagency
Ejemplo de aplicación cliente servidor con Sockets Java
El servidor de la agencia de viajes tiene dos formas de ejecutarse:

1.  Por herencia y reflexión (se define la clase en tiempo de ejecución)

Extendiendo la clase ServerSocketTemplate como en el caso de la clase TravelAgencyServerSocket
public class TravelAgencyServerSocket extends ServerSocketTemplate

En este caso deben ir al proyecto ServerSocket Template y buscar el archivo config.propierties y configurar la clase que extiende al servidor básico.
className=co.unicauca.travelagency.server.infra.TravelAgencyServerSocket

Se debe ejecutar en  proyecto ServerSocket Template la clase ExecuteServer

2.  Por composición y sin reflexión (al menos a la vista)

En este caso se debe ir a al proyecto TravelAgencyServer, extender la clase ServerHandler y reutilizar la clase ServerSocketMultiThread. En este caso se instancia  objetos de esta clases y se fija el objeto handler al objeto servidor myServer.setServerHandler(myHandler);

Finalmente, para este caso, sólo hay que ejecutar este código que está disponible en el main de la clase TravelAgencyServer. No hay que hacer nada más ni configurar ningún archivo de propiedades.
