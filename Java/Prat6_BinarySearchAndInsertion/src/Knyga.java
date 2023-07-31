import java.util.Objects;

public class Knyga implements Comparable {

    private String autorius;
    private String pavadinimas;


// 1) desinias peles klavisas Generate -> Constructor

    public Knyga(String autorius, String pavadinimas) {
        this.autorius = autorius;
        this.pavadinimas = pavadinimas;
    }
    // 2) desinias peles klavisas Generate -> toString

    @Override
    public String toString() {
        return "Knyga{" +
                "autorius='" + autorius + '\'' +
                ", pavadinimas='" + pavadinimas + '\'' +
                '}';
    }

    // 3.1) patikslinti: public class Knyga implements Comparable

    // 3.2) desinias peles klavisas Generate -> implement methods -> compareTo

    // 3.3) compareTo metodas palygina pradzioje pagal autoriu, po to pagal pavadinima:
    @Override
    public int compareTo(Object o) {
        Knyga k = (Knyga) o;
        int res = autorius.compareTo(k.getAutorius());
        if (res == 0)
            return pavadinimas.compareTo(k.getPavadinimas());
        return res;


        // 4) desinias peles klavisas Generate -> Getter and Setter
    }

    public String getAutorius() {
        return autorius;
    }

    public void setAutorius(String autorius) {
        this.autorius = autorius;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    // 5) desinias peles klavisas Generate -> equals and hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knyga knyga = (Knyga) o;
        return Objects.equals(autorius, knyga.autorius) && Objects.equals(pavadinimas, knyga.pavadinimas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autorius, pavadinimas);
    }
}