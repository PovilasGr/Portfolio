
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BTreeMap bt = new BTreeMap(3);
                
        bt.set(4, new Preke(4,"D"));
        bt.set(8, new Preke(8,"H"));
        bt.set(1, new Preke(1,"A"));
        bt.set(5, new Preke(5,"E"));
        bt.set(9, new Preke(9,"I"));
        bt.set(10, new Preke(10,"J"));
        bt.set(3, new Preke(3,"C"));
        bt.set(2, new Preke(2,"B"));
        bt.set(6, new Preke(6,"F"));
        bt.set(7, new Preke(7,"G"));
        bt.set(11, new Preke(11,"K"));
        bt.set(12, new Preke(12,"L"));
        bt.set(13, new Preke(13,"M"));
        bt.set(14, new Preke(14,"N"));
        bt.traverse();

    }
    
    
}
