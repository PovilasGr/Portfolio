
import java.util.Objects;

public class Pacientas {
    private String kodas;      // paciento unikalus kodas, pvz. A1, A2, B1, B2,…
    private String pavarde;
    private boolean skubus;    // true / false
   
    public Pacientas(String kodas, String pavarde, boolean skubus) {
        setKodas(kodas);
        setPavarde(pavarde);
        setSkubus(skubus);
    }
    
    @Override
    public String toString() {
        return "Pacientas: kodas=" + kodas + " pavarde=" + pavarde + " skubus=" + skubus;
    }
    
    @Override
    public boolean equals(Object obj) {
        // Jei obj lyginamas su savimi, return true  
        if (obj == this) {
            return true;
        }
 
        // Check if object is instance of Pacientas
        if (!(obj instanceof Pacientas)) {
            return false;
        }
        
        // pacientai lygus, jei ju kodai sutampa ir ‘skubus’ reikšmės sutampa
        Pacientas p = (Pacientas) obj;
        return this.getKodas().equals(p.getKodas()) && this.isSkubus() == p.isSkubus();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.kodas);
        hash = 89 * hash + (this.skubus ? 1 : 0);
        return hash;
    }

    /**
     * @return the kodas
     */
    public String getKodas() {
        return kodas;
    }

    /**
     * @param kodas the kodas to set
     */
    public void setKodas(String kodas) {
        this.kodas = kodas;
    }

    /**
     * @return the pavarde
     */
    public String getPavarde() {
        return pavarde;
    }

    /**
     * @param pavarde the pavarde to set
     */
    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    /**
     * @return the skubus
     */
    public boolean isSkubus() {
        return skubus;
    }

    /**
     * @param skubus the skubus to set
     */
    public void setSkubus(boolean skubus) {
        this.skubus = skubus;
    }
}
