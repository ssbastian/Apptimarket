
package co.unicauca.apptimarket.commons.domain;

/**
 *
 * @author WINDOWS
 */
public class Buy 
{
    private String atrCodigoCompra;
    private String atrNumeroCompra;
    private String atrTotal;
    private String atrDescripcion;

    
    public Buy()
    {}
    
    public Buy(String prmCodigoCompra, String prmNumeroCompra, String prmTotal, String prmDescripcion) 
    {
        atrCodigoCompra = prmCodigoCompra;
        atrNumeroCompra = prmNumeroCompra;
        atrTotal = prmTotal;
        atrDescripcion = prmDescripcion;
    }
    
    public String getCodigoCompra() {
        return atrCodigoCompra;
    }

    public void setCodigoCompra(String prmCodigoCompra) {
        atrCodigoCompra = prmCodigoCompra;
    }

    public String getNumeroCompra() {
        return atrNumeroCompra;
    }

    public void setNumeroCompra(String prmNumeroCompra) {
        this.atrNumeroCompra = prmNumeroCompra;
    }

    public String getTotal() {
        return atrTotal;
    }

    public void setTotal(String prmTotal) {
        atrTotal = prmTotal;
    }

    public String getDescripcion() {
        return atrDescripcion;
    }

    public void setDescripcion(String prmDescripcion) {
        atrDescripcion = prmDescripcion;
    }
    
    
}
