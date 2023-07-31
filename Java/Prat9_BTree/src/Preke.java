import java.io.Serializable;
import java.util.Objects;

public class Preke implements Serializable, Comparable<Preke> {

    private int kodas;
    private String pavadinimas;
	
    public Preke() {}
    
    public Preke(int pKodas, String pPav) {
        if(pKodas < 0 || pPav == null) throw new NullPointerException();
        
        kodas = pKodas;
        pavadinimas = pPav;
    }
        
    @Override
    public String toString() { 
        return getKodas() + getPavadinimas();
    }

    /**
     * Natural comparator
     * Compares the receiving object (this) with the specified object p
     * @param p
     * @return -1 if this < obj, 0 if this == obj, 1 if this > obj
     */
    @Override
    public int compareTo(Preke p) {
        int res = Integer.compare(this.getKodas(), p.getKodas());
        if(res == 0)
            return this.getPavadinimas().compareTo(p.getPavadinimas()) ;
        else return res;

    }
    /**
     * Compares the receiving object (this) with the specified object p1
     * @param p1
     * @return true if specified values of variables of this object are equal to corresponding variables of object p1, otherwise return false
     */
    @Override
    public boolean equals(Object p1) {
        boolean res = false;
        if(p1 instanceof Preke) {
            Preke p = (Preke) p1;
            if(this.getKodas() == p.getKodas() && this.getPavadinimas().equals(p.getPavadinimas()))
                res = true;
        }
        return res;
    }
    
    /**
     * Generates hash code for this object
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.kodas;
        hash = 59 * hash + Objects.hashCode(this.pavadinimas);
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
        if(kodas < 0) {
            System.out.println("Preke.setKodas(): bandoma irasyti bloga prekes kodo reiksme: kodas=" + kodas);
            throw new NullPointerException();
        }
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
        if(pavadinimas == null) {
            System.out.println("Preke.setPavadinimas(): Blogas prekes pavadinimas=null");
            throw new NullPointerException();
        }
        this.pavadinimas = pavadinimas;
    }

}
