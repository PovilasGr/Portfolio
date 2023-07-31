
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Double Linked List pavyzdys
 */
public class Main {

    public static void main(String[] args) {

       Preke p0 = new Preke(0, "Pienas",     "LT", 2);
       Preke p1 = new Preke(1, "Knyga",      "EN", 10);
       Preke p2 = new Preke(2, "Duona",      "LT", 1);
       Preke p3 = new Preke(3, "Suris",      "EN", 8);
       Preke p4 = new Preke(4, "Saldainiai", "EN", 5);

       System.out.println("======== MyLinkedList ========");
       // Naudojame savo sukurta doubly linked list klase MyLinkedList
       MyLinkedList l = new MyLinkedList();
       l.add(p0);
       l.add(p1);
       l.add(p2);
       spausdinti(l);
       
       l.set(2, p3);
       spausdinti(l);
       
       l.add(3, p4); // demesio: leidzia insert i 3 pozicija, nors masyvo indeksai yra nuo 0 iki 2
       spausdinti(l);
       
       // Java turi atitinkama klase LinkedList
       System.out.println("======== java.util.LinkedList ========");
       
       LinkedList ll = new LinkedList();
       ll.add(p0);
       ll.add(p1);
       ll.add(p2);
       spausdinti(ll);
       
       ll.set(2, p3);
       spausdinti(ll);
       
       ll.add(3, p4); // demesio: leidzia insert i 3 pozicija, nors masyvo indeksai yra nuo 0 iki 2
       spausdinti(ll);
       
       // Naudojame savo sukurta array list klase MyArrayList
       System.out.println("======== MyArrayList ========");
       MyArrayList a = new MyArrayList();
       
       a.add(p0);
       a.add(p1);
       a.add(p2);
       
       spausdinti(a);
       
       a.set(0, p3);
       spausdinti(a);
       
       a.add(0, p4);
       System.out.println("size=" + a.size());
       spausdinti(a);

       a.remove(1);
       System.out.println("size=" + a.size());
       spausdinti(a);
       
       // Java turi atitinkama klase ArrayList
       System.out.println("======== java.util.ArrayList ========");
       ArrayList al = new ArrayList();
       
       al.add(p0);
       al.add(p1);
       al.add(p2);
       
       spausdinti(al);
        
    }
    
    public static void spausdinti(MyList l) {
        for(int i = 0; i < l.size(); i++) {
           System.out.println(l.size() + ": " +  l.get(i));
       }
       System.out.println();
    }
    
    public static void spausdinti(List l) {
        for(int i = 0; i < l.size(); i++) {
           System.out.println(l.size() + ": " +  l.get(i));
       }
       System.out.println();
    }
}
