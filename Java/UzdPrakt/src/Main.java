import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) {
        Pagalbine pagalb = new Pagalbine();

        //----------- Nuskaitome duomenis is Json failu -----------
        DuomenuNuskaitymas duomSkaitymas = new DuomenuNuskaitymas();

        HashMap<Integer,Preke> prekesHM = duomSkaitymas.nuskaitytiVisasPrekesHM("./Json_files/PrekesHM.json");
        pagalb.spausdink(prekesHM);

        ArrayList pirkiniai = duomSkaitymas.nuskaitytiVisusPirkinius("./Json_files/Pirkiniai.json");
        pagalb.spausdink(pirkiniai);

        // Pagal prekes koda surandame prekiu pavadinimus sarase prekesHM ir irasome i pirkimus
        System.out.println("\nSurasti prekiu pavadinimai:");
        pagalb.suraskPrekiuPavadinimusMap(pirkiniai, prekesHM);
        pagalb.spausdink(pirkiniai);

        //------------------ RUSIAVIMAS naudojant Comparator ---------------------
        InsertionSort srt = new InsertionSort();

        System.out.println("\nRusiuojama kvieciant PirkiniaiComparator esanti metoda compare():");
        srt.sort(pirkiniai, new PirkiniaiComparator());
        pagalb.spausdink(pirkiniai);


        //------------------ arba RUSIAVIMAS naudojant Comparable ---------------------
        System.out.println("\nRusiuojama kvieciant JavaBean klaseje esanti metoda compareTo():");
        srt.sort(pirkiniai);
        pagalb.spausdink(pirkiniai);

    }
}
