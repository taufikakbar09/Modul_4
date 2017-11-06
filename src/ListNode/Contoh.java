package ListNode;

public class Contoh {
// data members

    static Object[] a; // array that contains the tree
    static int last = 0; // position of last element in array a
    static int size = 0;

    /**
     * visit method that prints the element in a[i]
     */
    public static void visit(int i) {
        System.out.print(a[i] + " ");
    }

    /**
     * inorder traversal
     */
    public static void inOrder(Object[] theArray, int theLast) {
// set static data members
        a = theArray;
        last = theLast;

        if (!isEmpty()) {
// start the recursive traversal method at the root
            theInOrder(1);
        } else {
            System.out.println("Binary Tree Kosong");
        }
    }

    /**
     * actual method to do the inorder traversal
     */
    static void theInOrder(int i) {// traverse subtree rooted at a[i]
        if (i <= last && a[i] != null) {// root exists
            theInOrder(2 * i); // do left subtree
            visit(i); // visit tree root
            theInOrder(2 * i + 1); // do right subtree
        }
    }

    static boolean isEmpty() {
        return (size == 0);
    }

    static void addNode(int i, int isi) {
        a[i] = new Integer(isi);
        size++;
        last = i;
    }

    public static void preOrder(Object[] theArray, int theLast) {
// set static data members
        a = theArray;
        last = theLast;

        if (!isEmpty()) {
// start the recursive traversal method at the root
            thePreOrder(1);
        } else {
            System.out.println("Binary Tree Kosong");
        }
    }

    static void thePreOrder(int i) {// traverse subtree rooted at a[i]
        if (i <= last && a[i] != null) {// root exists

            visit(i); // visit tree root
            thePreOrder(2 * i); // do left subtree
            thePreOrder(2 * i + 1); // do right subtree
        }
    }

    public static void postOrder(Object[] theArray, int theLast) {
// set static data members
        a = theArray;
        last = theLast;

        if (!isEmpty()) {
// start the recursive traversal method at the root
            thePostOrder(1);
        } else {
            System.out.println("Binary Tree Kosong");
        }
    }

    static void thePostOrder(int i) {// traverse subtree rooted at a[i]
        if (i <= last && a[i] != null) {// root exists

            thePostOrder(2 * i); // do left subtree
            thePostOrder(2 * i + 1); // do right subtree
            visit(i); // visit tree root
        }
    }

    public static void main(String[] args) { // method main
        a = new Integer[10];
        Contoh out = new Contoh();

        out.addNode(1, 3);
        out.addNode(2, 2);
        out.addNode(3, 9);
        out.addNode(4, 4);
        out.addNode(5, 5);
        out.addNode(6, 6);
        out.addNode(8, 10);
        out.inOrder(a, last);
        System.out.println();
        out.preOrder(a, last);
        System.out.println();
        out.postOrder(a, last);

    }
}
