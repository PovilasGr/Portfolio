public class Preke {
    private int kodas;
    private String Pavadinimas;
    private String Salis;
    private float kainaVnt;
    private boolean valgomas;

    public Preke() {}

    public Preke(int pKodas, String pPav, String pSalis, float pKainaVnt) {
        if(pKodas < 0 || pPav == null)
                throw new NullPointerException();

        kodas = pKodas;
        Pavadinimas = pPav;
        Salis = pSalis;
        kainaVnt = pKainaVnt;
    }

    @Override
    public String toString() {
        String rez = "Preke: kodas = " + getKodas() + "; pav = " + getPavadinimas()
            +   "; salis = " + getSalis() + "kainaVnt = " + getKainaVnt();
        return rez;
    }

    /**
     * Natural comparator
     * Compares the reveiving object
     * @param p1
     * @return -1, 0, 1
     */


    public int compareTo (Object p1) {
        Preke p = (Preke) p1;
        if (this.kodas > p.kodas)
            return 1;
        else if(this.kodas < p.kodas)
            return -1;
        else
            return 0;
    }

    public int getKodas() {
        return kodas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public String getPavadinimas() {
        return Pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        Pavadinimas = pavadinimas;
    }

    public String getSalis() {
        return Salis;
    }

    public void setSalis(String salis) {
        Salis = salis;
    }

    public float getKainaVnt() {
        return kainaVnt;
    }

    public void setKainaVnt(float kainaVnt) {
        this.kainaVnt = kainaVnt;
    }

    public boolean isValgomas() {
        return valgomas;
    }

    public void setValgomas(boolean valgomas) {
        this.valgomas = valgomas;
    }
}
