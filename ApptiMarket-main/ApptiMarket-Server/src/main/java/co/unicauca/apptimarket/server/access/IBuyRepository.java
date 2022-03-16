
package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Buy;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public interface IBuyRepository 
{
    public Buy findBuy(String prmCode);
    public String createBuy(Buy prmBuy);
    public List<Buy> findBuys();  //retornar lista de compras
}
