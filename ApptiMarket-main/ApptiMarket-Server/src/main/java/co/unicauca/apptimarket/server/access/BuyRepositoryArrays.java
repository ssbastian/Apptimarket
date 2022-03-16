
package co.unicauca.apptimarket.server.access;

import co.unicauca.apptimarket.commons.domain.Buy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public class BuyRepositoryArrays implements IBuyRepository
{
    private static List<Buy> ListBuys;

    public BuyRepositoryArrays() {
        if (ListBuys == null) {
            ListBuys = new ArrayList();
        }
    }
    
    @Override
    public String createBuy(Buy prmBuy) {
        ListBuys.add(prmBuy);
        return prmBuy.getCodigoCompra();
    }

    @Override
    public Buy findBuy(String prmCode) {
        for (Buy buy : ListBuys) {
            if (buy.getCodigoCompra().equals(prmCode)) {
                return buy;
            }
        }
        return null;
    }

    @Override
    public List<Buy> findBuys() {
        return ListBuys;
    }
    
}
