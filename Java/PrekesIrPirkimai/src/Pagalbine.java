import java.util.ArrayList;
import java.util.HashMap;

public class Pagalbine {

    public void spausdink(ArrayList sarasas) {
        for (Object p : sarasas) {
            System.out.println(p);
        }

        //arba:
        //sarasas.forEach(  (Object p) -> {System.out.println(p);}   );
    }

    /*public void suraskPrekiuPavadinimus(ArrayList<Pirkinys> pirkiniai, ArrayList<Preke> prekes) {
        // TODO suprogramuoti prekes pavadinimo radima
    }*/
}
