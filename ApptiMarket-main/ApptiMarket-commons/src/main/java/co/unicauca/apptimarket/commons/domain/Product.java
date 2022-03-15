package co.unicauca.apptimarket.commons.domain;

/**
 * Cliente de la agencia de viajes
 *
 * @author Libardo, Julio
 */
public class Product {

   private String atrCodigoProducto;
   private String atrNombre;
   private double atrPrecio;
   private int atrExistencia;
   private String atrTipo;

   //imagen

    /**
     * Constructor parametrizado
     *
     * @param prmCodigoProducto
     * @param prmNombre
     * @param prmPrecio
     * @param prmExistencia
     * @param prmTipo
     */
    public Product(String prmCodigoProducto, String prmNombre, double prmPrecio, int prmExistencia, String prmTipo) 
    {
        atrCodigoProducto = prmCodigoProducto;
        atrNombre = prmNombre;
        atrPrecio = prmPrecio;
        atrExistencia = prmExistencia;
        atrTipo = prmTipo;
        
    }

    /**
     * Constructor por defecto
     */
    public Product() {

    }

    public String getAtrCodigoProducto() {
        return atrCodigoProducto;
    }

    public void setAtrCodigoProducto(String atrCodigoProducto) {
        this.atrCodigoProducto = atrCodigoProducto;
    }

    public String getAtrNombre() {
        return atrNombre;
    }

    public void setAtrNombre(String atrNombre) {
        this.atrNombre = atrNombre;
    }

    public double getAtrPrecio() {
        return atrPrecio;
    }

    public void setAtrPrecio(double atrPrecio) {
        this.atrPrecio = atrPrecio;
    }

    public int getAtrExistencia() {
        return atrExistencia;
    }

    public void setAtrExistencia(int atrExistencia) {
        this.atrExistencia = atrExistencia;
    }

    public String getAtrTipo() {
        return atrTipo;
    }

    public void setAtrTipo(String atrTipo) {
        this.atrTipo = atrTipo;
    }

    

}
