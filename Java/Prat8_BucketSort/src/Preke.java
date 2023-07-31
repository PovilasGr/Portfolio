import java.io.Serializable;

public class Preke implements Serializable, Comparable {

    private int kodas;
    private String pavadinimas;

    public Preke() {}
    
    public Preke(int pKodas, String pPav) {
        if(pKodas < 0 || pPav == null)
            throw new NullPointerException();
        
        kodas = pKodas;
        pavadinimas = pPav;
    }
        
    @Override
    public String toString() { 
        return "[" + getKodas() + ":" + getPavadinimas() + "]";
    }
    
    /**
     * Natural comparator
     * Compares the receiving object (this) with the specified object p1
     * @param p1
     * @return -1, 0, 1
     */
    @Override
    public int compareTo(Object p1) {
        Preke p = (Preke) p1;
        if(this.getKodas() == p.getKodas())
            return 0;
        else if (this.getKodas() > p.getKodas()) return 1;
        else return -1;
    }

    // Equal objects must have equal hash codes
    // t.y. metodai equals() ir hashCode() turi buti suderinti
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Preke))
            return false;
        Preke p = (Preke) o;
        return p.getKodas() == this.getKodas();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.kodas;
        return hash;
    }
    
    /**
     * @return the kodas
     */
    public int getKodas() {
        return kodas;
    }

    /**
     * @param kodas the kodas to set
     */
    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    /**
     * @return the pavadinimas
     */
    public String getPavadinimas() {
        return pavadinimas;
    }

    /**
     * @param pavadinimas the pavadinimas to set
     */
    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

}
