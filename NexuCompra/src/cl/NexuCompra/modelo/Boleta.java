
package cl.NexuCompra.modelo;

/**
 *
 * @author Andaur - Cornejo
 * @version 1.0
 */
public class Boleta {
    
    private String nombreb, rutb, apellidob, nombreprob, descripcionb;
    
    private int codigob, preciob, cantidadb;

    public Boleta() {
    }

    public Boleta(String nombreb, String rutb, String apellidob, String nombreprob, String descripcionb, int codigob, int preciob, int cantidadb) {
        this.nombreb = nombreb;
        this.rutb = rutb;
        this.apellidob = apellidob;
        this.nombreprob = nombreprob;
        this.descripcionb = descripcionb;
        this.codigob = codigob;
        this.preciob = preciob;
        this.cantidadb = cantidadb;
    }

    public String getNombreb() {
        return nombreb;
    }

    public void setNombreb(String nombreb) {
        this.nombreb = nombreb;
    }

    public String getRutb() {
        return rutb;
    }

    public void setRutb(String rutb) {
        this.rutb = rutb;
    }

    public String getApellidob() {
        return apellidob;
    }

    public void setApellidob(String apellidob) {
        this.apellidob = apellidob;
    }

    public String getNombreprob() {
        return nombreprob;
    }

    public void setNombreprob(String nombreprob) {
        this.nombreprob = nombreprob;
    }

    public String getDescripcionb() {
        return descripcionb;
    }

    public void setDescripcionb(String descripcionb) {
        this.descripcionb = descripcionb;
    }

    public int getCodigob() {
        return codigob;
    }

    public void setCodigob(int codigob) {
        this.codigob = codigob;
    }

    public int getPreciob() {
        return preciob;
    }

    public void setPreciob(int preciob) {
        this.preciob = preciob;
    }

    public int getCantidadb() {
        return cantidadb;
    }

    public void setCantidadb(int cantidadb) {
        this.cantidadb = cantidadb;
    }

    @Override
    public String toString() {
        return "Boleta{" + "nombreb=" + nombreb + ", rutb=" + rutb + ", apellidob=" + apellidob + ", nombreprob=" + nombreprob + ", descripcionb=" + descripcionb + ", codigob=" + codigob + ", preciob=" + preciob + ", cantidadb=" + cantidadb + '}';
    }
    
}
