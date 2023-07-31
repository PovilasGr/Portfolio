
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        // Duomenys nerusiuoti, yra sutampanciu pavadinimu, pvz. Pienas:
        ArrayList<Preke> prekes = new ArrayList();
        Preke p0 = new Preke(0, "Pienas",     "LT", 2);
        Preke p1 = new Preke(1, "Knyga",      "EN", 10);
        Preke p2 = new Preke(2, "Duona",      "LT", 1);
        Preke p3 = new Preke(3, "Suris",      "EN", 8);
        Preke p4 = new Preke(4, "Pienas",     "LV", 2);
        Preke p5 = new Preke(5, "Piestukas",  "LT", (float)0.2);
        Preke p6 = new Preke(6, "Pienas",     "PL", (float)0.3);
        Preke p7 = new Preke(7, "Pienas",     "EST", 3);
        
        prekes.add(p7); prekes.add(p3); prekes.add(p6); prekes.add(p2);
        prekes.add(p1); prekes.add(p5); prekes.add(p0); prekes.add(p4);
        
        spausdink(prekes);
        
        ArrayList<Preke> prekesSorted = new ArrayList();
        
        BinarySearchInsert binIns = new BinarySearchInsert();
        
        // duomenys iterpiami surusiuota tvarka:
        for (Preke p : prekes) {
            binIns.insert(prekesSorted, p); 
        }
        spausdink(prekesSorted);

        System.out.println("-----------------------------");

        System.out.println("======= Knygos =======");
        Knyga k00 = new Knyga("aut0", "pav0");
        Knyga k01 = new Knyga("aut0", "pav1");
        Knyga k10 = new Knyga("aut1", "pav0");
        Knyga k11 = new Knyga("aut1", "pav1");
        Knyga k12 = new Knyga("aut1", "pav2");

        KnyguSortedList knyguList = new KnyguSortedList();

        knyguList.add(k12);
        knyguList.add(k01);
        knyguList.add(k11);
        knyguList.add(k00);
        knyguList.add(k10);
        knyguList.add(k10);

        spausdink(knyguList);

    }
    
    public static void spausdink(List sarasas) {
        for (Object p : sarasas) {
            System.out.println(p);
        }
        System.out.println();
    }

    public static void spausdink(MyList sarasas) {
        for(int i = 0; i < sarasas.size(); i++) {
            System.out.println(sarasas.size() + ": " +  sarasas.get(i));
        }
        System.out.println();
    }
}
