import java.util.ArrayList;
import java.util.HashMap;

public class Pagalbine {

    public void spausdink(ArrayList sarasas) {
        for (Object p : sarasas) {
            System.out.println(p);
        }
        System.out.println();
        // arba:
        //sarasas.forEach(  (Object p) -> {System.out.println(p);}   );
    }

    // Letas budas surasti prekiu pavadinimus pagal prekiu kodus,
    // nes sukamas ciklas cikle
    public void suraskPrekiuPavadinimus(ArrayList<Pirkinys> pirkiniai, ArrayList<Preke> prekes) {


        for (Pirkinys prk : pirkiniai) {
            for(Preke p : prekes) {
                if(prk.getPrekesKodas() == p.getKodas())
                    prk.setPrekesPav(p.getPavadinimas());
                    break;
            }
        }
    }
 
    // Prekes issaugojame HashMap duomenu strukturoje, kur paieska yra greitesne
    public HashMap<Integer,Preke> prekiuHashMap (ArrayList<Preke> prekes){
        HashMap<Integer, Preke> prekesHM = new HashMap(); // key -> value

        for(Preke p : prekes) {
            prekesHM.put(p.getKodas(), p);
        }
        return prekesHM;
    }
    
    public void spausdink(HashMap<Integer,Preke> prekesHM) {
        for (HashMap.Entry entry : prekesHM.entrySet()) {
            System.out.println("PrekiuHashMap: " + entry.getKey() + " : " + entry.getValue());
        }
        // arba:
        //prekesHM.forEach((key, value) -> System.out.println("PrekiuHashMap: " + key + " : " + value));
        
        System.out.println();
    }
    
    // Greitesnis budas surasti prekiu pavadinimus pagal prekiu kodus,
    // nes sukamas tik vienas ciklas for
    //
    public void suraskPrekiuPavadinimusMap(ArrayList<Pirkinys> pirkiniai, HashMap<Integer,Preke> prekesMap) {

        for(Pirkinys prk : pirkiniai) {
            int id = prk.getPrekesKodas();
            if(prekesMap.containsKey(id)) {
                Preke p = prekesMap.get(id);
                prk.setPrekesPav(p.getPavadinimas());
            }
        }
    }
}
