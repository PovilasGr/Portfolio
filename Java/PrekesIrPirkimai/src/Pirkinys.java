public class Pirkinys {
    private int zmogausId;
    private int prekesId;
    private int vnt;
    private String prekesPav;

    public Pirkinys () {}

    public Pirkinys(int zmId, int prId,String prPav, int vienetai) {
        zmogausId = zmId;
        prekesId = prId;
        prekesPav =  prPav;
        vnt = vienetai;
    }

    @Override
    public String toString () {
        String rez = "Pirkinys: zmogausId = " + getZmogausId()
                + "; prekesId = " + getPrekesId()
                + "; prekesPav = " + getPrekesPav()
                + "; vnt = " + getVnt();
        return rez;
    }

    public int getZmogausId() {
        return zmogausId;
    }

    public void setZmogausId(int zmogausId) {
        this.zmogausId = zmogausId;
    }

    public int getPrekesId() {
        return prekesId;
    }

    public void setPrekesId(int prekesId) {
        this.prekesId = prekesId;
    }

    public int getVnt() {
        return vnt;
    }

    public void setVnt(int vnt) {
        this.vnt = vnt;
    }

    public String getPrekesPav() {
        return prekesPav;
    }

    public void setPrekesPav(String prekesPav) {
        this.prekesPav = prekesPav;
    }
}

