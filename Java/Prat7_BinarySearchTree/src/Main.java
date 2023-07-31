
public class Main {

    public static void main(String[] args) {
        System.out.println("~~~ Programiskai i medi idedami nauji mazgai ~~~");
        
        BinarySearchTree bst = new BinarySearchTree(new CmpPreke());
        bst.insert(new Preke(5,"I"));
        bst.insert(new Preke(2,"D"));
        bst.insert(new Preke(7,"L"));
        bst.insert(new Preke(1,"A"));
        bst.insert(new Preke(3,"F"));
        bst.insert(new Preke(6,"K"));
        bst.insert(new Preke(8,"M"));
        bst.insert(new Preke(4,"H"));
        bst.insert(new Preke(9,"P"));
        
        bst.printBinaryTree(bst.getRoot(), 0);
        System.out.println("\n");

        System.out.println("~~~ Kiti veiksmai ~~~");
        Node root = bst.getRoot();

        System.out.println("Min=" + root.minimum() + "; Max=" + root.maximum() + "\n");


        System.out.println("~~~ Inorder traversal: mazesnis vaikas -> tevas -> didesnis vaikas ~~~");
        bst.inOrder(bst.getRoot());
        System.out.println("\n");
        
        System.out.println("~~~ Reversed inorder traversal: didesnis vaikas -> tevas -> mazesnis vaikas ~~~");
        bst.inOrderRev(bst.getRoot());
        System.out.println("\n");
        
        System.out.println("~~~ Preorder traversal: tevas -> mazesnis vaikas -> didesnis vaikas ~~~");
        bst.preOrder(bst.getRoot());
        System.out.println("\n");


    }
}
