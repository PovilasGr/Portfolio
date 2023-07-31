
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------hashTable Preke---------------\n");

        ArrayList<Preke> prekes = new ArrayList();

        prekes.add(new Preke(0, "Pienas"));
        prekes.add(new Preke(1, "Knyga"));
        prekes.add(new Preke(2, "Duona"));
        prekes.add(new Preke(3, "Suris"));
        prekes.add(new Preke(4, "Saldainiai"));
        prekes.add(new Preke(5, "Piestukas"));
        prekes.add(new Preke(6, "Trintukas"));
        prekes.add(new Preke(7, "Sultys"));

        spausdink(prekes);

        MyHashtable htPrekes = new MyHashtable(5, 0.85f);

        for (Preke p : prekes) {
            htPrekes.add(p);
        }
        htPrekes.print();

        System.out.println("\n--------------------------\n");

        int hash;

        hash = "aaa".hashCode(); // hash=96321
        System.out.println("\"aaa\".hashCode()=" + hash);

        hash = "Saldainiai".hashCode(); // hash=-1976754383
        System.out.println("\"Saldainiai\".hashCode()=" + hash);

        hash = hash & 0x7FFFFFFF; // hash=170729265
        System.out.println("Saldainiai: hash&0x7FFFFFFF=" + hash);

        System.out.println("");

        int min = Integer.MIN_VALUE;
        int val;

        val = Math.abs(Integer.MIN_VALUE); // MIN=-2147483648, Math.abs(MIN)=-2147483648
        System.out.println("MIN=" + min + ", Math.abs(MIN)=" + val);

        val = Integer.MIN_VALUE & 0x7FFFFFFF; // MIN=-2147483648, MIN&0x7FFFFFFF=0
        System.out.println("MIN=" + min + ", MIN&0x7FFFFFFF=" + val);

        System.out.println("");

        System.out.println("Integer.hashCode(10)=" + Integer.hashCode(10)); //hashCode(10)=10 
        System.out.println("Double.hashCode(2.5)=" + Double.hashCode(2.5)); //hashCode(2.5)=1074003968

    }
    
    public static void spausdink(ArrayList sarasas) {
        for (Object p : sarasas) {
            System.out.println(p);
        }
        System.out.println();
    }
}
