
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Preke p1 = new Preke(9, "aaa");
        Preke p2 = new Preke(26, "bbb");
        Preke p3 = new Preke(24, "bbb");
        Preke p4 = new Preke(17, "ccc");
        Preke p5 = new Preke(4, "ddd");
        Preke p6 = new Preke(22, "eee");
        Preke p7 = new Preke(12, "eee");
        Preke p8 = new Preke(10, "eee");

        List<Preke> prekes = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);

        //ArrayList<Preke> prekes = new ArrayList();
        //prekes.add(p1); prekes.add(p2); prekes.add(p3); prekes.add(p4);
        //prekes.add(p5); prekes.add(p6); prekes.add(p7); prekes.add(p8);
        
        spausdink(prekes);

        BucketSortas srt = new BucketSortas();
        srt.sort(prekes, 6);
        spausdink(prekes);
    }
    
    public static void spausdink(List sarasas) {
        System.out.println(sarasas);
        System.out.println("\n");
    }
}
