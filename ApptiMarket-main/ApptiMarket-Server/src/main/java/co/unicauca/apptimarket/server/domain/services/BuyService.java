
package co.unicauca.apptimarket.server.domain.services;

import co.unicauca.apptimarket.commons.domain.Buy;
import co.unicauca.apptimarket.commons.infra.JsonError;
import co.unicauca.apptimarket.commons.infra.Utilities;
import co.unicauca.apptimarket.server.access.IBuyRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WINDOWS
 */
public class BuyService 
{
    IBuyRepository repo;
    
    public BuyService(IBuyRepository repo) {
        this.repo = repo;
    }
    
    public synchronized Buy findBuy(String prmCode) {
        return repo.findBuy(prmCode);
    }
    
    public synchronized String createbBuy(Buy prmBuy) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (prmBuy.getCodigoCompra().isEmpty() || prmBuy.getNumeroCompra().isEmpty()
                || prmBuy.getTotal().isEmpty() || prmBuy.getDescripcion().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "código, nombre, precio, existencias y tipo son obligatorios. "));
        }

        if (!Utilities.isNumeric(prmBuy.getCodigoCompra())) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El código debe ser numérico. "));

        }
        // Que no esté repetido

        Buy buySearched = this.findBuy(prmBuy.getCodigoCompra());
        if (buySearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El código ya existe. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createBuy(prmBuy);
    }
    
    public synchronized List<Buy> findBuys() {
       return repo.findBuys();
    }
}
