
package co.unicauca.apptimarket.client.access;

import co.unicauca.apptimarket.commons.domain.Buy;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public interface IBuyAccess 
{
    public String createBuy(Buy prmBuy) throws Exception;
    public Buy findBuy(String prmCode) throws Exception;
    public List<Buy> findBuys() throws Exception;
}
