import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) {
        // Susikuriame duomenis        
        Preke p0 = new Preke(0, "Pienas",     "LT", 2);
        Preke p1 = new Preke(1, "Knyga",      "EN", 10);
        Preke p2 = new Preke(2, "Duona",      "LT", 1);
        Preke p3 = new Preke(3, "Suris",      "EN", 8);
        Preke p4 = new Preke(4, "Saldainiai", "EN", (float)5.4);
        Preke p5 = new Preke(5, "Piestukas",  "LT", (float)0.2);

        System.out.println(p0); // kviecia Preke klaseje esanti metoda toString()
        System.out.println(p4);

        System.out.println();

        //------------------------------------------
        //Duomenis susirasome i ArrayList duomenu struktura:
        ArrayList prekes = new ArrayList();

        prekes.add(p5); // duomenys nerusiuoti pagal prekes koda
        prekes.add(p3);
        prekes.add(p0);
        prekes.add(p2);
        prekes.add(p1);
        prekes.add(p4);
        
        //---------------------------------------------
        // Susikuriame duomenis ir susirasome i ArrayList duomenu struktura:
        ArrayList pirkiniai = new ArrayList();

        pirkiniai.add(new Pirkinys(1, 1, 2));   // int zmId, int prId, int vienetai
        pirkiniai.add(new Pirkinys(2, 3, 5));
        pirkiniai.add(new Pirkinys(1, 2, 3));
        pirkiniai.add(new Pirkinys(2, 5, 10));
        pirkiniai.add(new Pirkinys(2, 1, 5));

        //---------------------------------------
        Pagalbine pagalb = new Pagalbine();
        
        System.out.println("Nerusiuoti duomenys:");
        pagalb.spausdink(prekes);
        pagalb.spausdink(pirkiniai);
 
        //---------------------------------------
        InsertionSort srt = new InsertionSort();

        // Rusiuojama naudojant Comparator
        System.out.println("Rusiuojama naudojant Comparator:");
        srt.sort(prekes, new PrekesComparator());
        srt.sort(pirkiniai, new PirkiniaiComparator());
        pagalb.spausdink(prekes);
        pagalb.spausdink(pirkiniai);
        
        // Rusiuojama naudojant Java bibliotekoje esanti rusiavima Collections.sort() bei Comparator
        System.out.println("Rusiuojama su Collections.sort() ir Comparator:");
        Collections.sort(prekes, new PrekesComparator());
        Collections.sort(pirkiniai, new PirkiniaiComparator());
        pagalb.spausdink(prekes);
        pagalb.spausdink(pirkiniai);
        


    System.out.println("Surasti prekiu pavadinimai: ");
    pagalb.suraskPrekiuPavadinimus(pirkiniai, prekes);
    pagalb.spausdink(pirkiniai);

    HashMap<Integer, Preke> prekesHM = pagalb.prekiuHashMap(prekes);
    pagalb.spausdink(prekesHM);


    pagalb.suraskPrekiuPavadinimusMap(pirkiniai, prekesHM);
        System.out.println("Surasti prekiu pavadinimai, naudojant HashMap:");
        pagalb.spausdink(pirkiniai);



    }
}
