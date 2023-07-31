import java.io.Serializable;

public class Pirkinys implements Serializable, Comparable {

    private int zmogausId;
    private int prekesKodas;
    private int vnt;

    private String prekesPav;
    
    public Pirkinys() {      
    }

    public Pirkinys(int zmId, int prId, int vienetai) {
        zmogausId = zmId;
        prekesKodas = prId;
        vnt = vienetai;
    }
    
    @Override
    public String toString() { 
        String rez = "Pirkinys: zmogausId=" + getZmogausId() 
                + "; prekesKodas=" + getPrekesKodas()
                + "; prekesPav=" + getPrekesPav() 
                + "; vnt=" + getVnt();

        return rez;
    }

    /**
     * Natural comparator
     * Compares the receiving object (this) with the specified object p1
     * @param p1
     * @return -1, 0, 1
     */
    @Override
    public int compareTo(Object p1) {
        Pirkinys p = (Pirkinys) p1;
        if(this.zmogausId > p.zmogausId) 
            return 1;
        else if(this.zmogausId < p.zmogausId)
            return -1;
        else {
            return this.prekesPav.compareTo(p.prekesPav);
        } 
    }

    // Right mouse click -> Refactor -> Encapsulate fields -> Generate Getters/Setters

    /**
     * @return the zmogausId
     */
    public int getZmogausId() {
        return zmogausId;
    }

    /**
     * @param zmogausId the zmogausId to set
     */
    public void setZmogausId(int zmogausId) {
        this.zmogausId = zmogausId;
    }

    /**
     * @return the prekesKodas
     */
    public int getPrekesKodas() {
        return prekesKodas;
    }

    /**
     * @param prekesKodas the prekesKodas to set
     */
    public void setPrekesKodas(int prekesKodas) {
        this.prekesKodas = prekesKodas;
    }

    /**
     * @return the prekesPav
     */
    public String getPrekesPav() {
        return prekesPav;
    }

    /**
     * @param prekesPav the prekesPav to set
     */
    public void setPrekesPav(String prekesPav) {
        this.prekesPav = prekesPav;
    }
    
    /**
     * @return the vnt
     */
    public int getVnt() {
        return vnt;
    }

    /**
     * @param vnt the vnt to set
     */
    public void setVnt(int vnt) {
        this.vnt = vnt;
    }
}
