import java.io.Serializable;
import java.util.Objects;

/*
    A JavaBean is a Java object that satisfies certain programming conventions:
    - The JavaBean class must implement Serializable
    - The JavaBean class must have a no-arg constructor
    - All JavaBean instance variables should be private
    - All JavaBean properties must have public setter and getter methods
*/

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
        String rez = getKodas() + getPavadinimas() ;
        return rez;
    }

    /**
     * Natural comparator
     * Compares the receiving object (this) with the specified object p1
     * @param p1
     * @return -1 if this < obj, 0 if this == obj, 1 if this > obj
     */
    @Override
    public int compareTo(Object p1) {
        Preke p = (Preke) p1;
        if(this.getKodas() > p.getKodas()) 
            return 1;
        else if(this.getKodas() < p.getKodas())
            return -1;
        else 
            return this.getPavadinimas().compareTo(p.getPavadinimas()) ;
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

    // Right mouse click -> Refactor -> Encapsulate fields -> Generate Getters/Setters
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
            System.out.println("Preke.setPavadinimas(): Blogas prekes pavadinimas=" + pavadinimas);
            throw new NullPointerException();
        }
        this.pavadinimas = pavadinimas;
    }

}
