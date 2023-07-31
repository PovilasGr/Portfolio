import javax.sound.midi.Soundbank;
import java.io.PipedReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Preke p0 = new Preke (0, "Pienas", "LT", 2);
        Preke p1 = new Preke (1, "Knyga", "EN", 10);
        Preke p2 = new Preke (2, "Duona", "LT", 1.4f);
        Preke p3 = new Preke (3, "Suris", "EN", 8);

        System.out.println(p0);
        System.out.println(p2);

        ArrayList prekes = new ArrayList();

        prekes.add(p2);
        prekes.add(p0);
        prekes.add(p1);
        prekes.add(p3);
        System.out.println("Prekes:");
        Pagalbine pagalb = new Pagalbine();
        pagalb.spausdink(prekes);

        InsertionSort srt = new InsertionSort();

        srt.sort(prekes, new PrekesComparator());
        System.out.println("Rusiuota Prekes:");
        pagalb.spausdink(prekes);

        ArrayList pirkiniai = new ArrayList();

        pirkiniai.add(new Pirkinys (1, 1, "Pienas",  2));
        pirkiniai.add(new Pirkinys (2, 3, "Duona", 5));
        pirkiniai.add(new Pirkinys (1, 2, "Suris", 3));
        System.out.println("Pirkiniai:");
        pagalb.spausdink(pirkiniai);

        System.out.println("Rusiuota Pirkiniai:");
        srt.sort(pirkiniai, new PirkiniaiComparator());

        pagalb.spausdink(pirkiniai);
    }
}
