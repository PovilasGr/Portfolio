import java.util.ArrayList;
import java.util.HashMap;

public class Pagalbine {

    public void spausdink(ArrayList sarasas) {
        for (Object p : sarasas) {
            System.out.println(p);
        }
        System.out.println();
    }

    // Entry = [key; value]
    public void spausdink(HashMap<Integer,Preke> prekesHM) {
        for (HashMap.Entry entry : prekesHM.entrySet()) {
            System.out.println("PrekiuHashMap:" + entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

    public void suraskPrekiuPavadinimusMap(ArrayList<Pirkinys> pirkiniai,
                                           HashMap<Integer,Preke> prekesMap) {
        for(Pirkinys prk : pirkiniai) {
            int id = prk.getPrekesKodas();
            if(prekesMap.containsKey(id)) {
                Preke p = prekesMap.get(id);            // O(1)
                prk.setPrekesPav(p.getPavadinimas());
            }
        }
    }

}
