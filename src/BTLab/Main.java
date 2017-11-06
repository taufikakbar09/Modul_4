package BTLab;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
////        Scanner s = Scanner(System.in);
//        BinaryTree a = new BinaryTree();
//        a.add(5);
//        a.add(2);
//        a.add(9);
//        a.add(1);
//        a.add(4);
//        a.add(11);
//        a.add(12);
////        System.out.println("Masukkan Data : ");
//        
//        System.out.print("BST = ");
//        a.show(a.root);
//        System.out.println();
//        System.out.println("leaf binary = "+a.getLeaf());
//        System.out.println("rute");
//        a.printPaths(a.root);
////        System.out.println("Delete : " );
////        a.delete(2);
//        
//        System.out.println("");
//        System.out.print("preorder = ");
//        a.preOrder(a.root);
//        System.out.println("");
//        System.out.print("inorder = ");
//        a.inOrder(a.root);
//        System.out.println("");
//        System.out.print("postorder = ");
//        a.postOrder(a.root);
//        System.out.println("");
//        
//        System.out.println();
//        a.searchPaths(11);

        Scanner scan = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();           
        char ch;
        do{
            System.out.println("\nBinary Search Tree\n");
            System.out.println("1. Masukkan Data ");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Jalan");
//            System.out.println("4. Hitung Node");
            System.out.println("4. Hitung Leaf");
//            System.out.println("6. Cek kosong atau tidak"); 
            System.out.println("5. Tampilkan Data");
 
            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
                System.out.println("Masukkan Angka yang akan di masukkan");
                bt.add( scan.nextInt());                     
                break;                          
            case 2 : 
                System.out.println("Masukkan Angka yang akan di hapus");
                bt.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Masukkan Angka yang akan di cari");
                int a = scan.nextInt();
                System.out.println("Hasil pencarian : ");
                bt.searchPaths(a);
                break;                                          
//            case 4 : 
//                System.out.println("Banyak Node = "+ bst.countNodes());
//                break;
            case 4 : 
                System.out.println("Banyak Leaf = "+ bt.getLeaf());
                break;
//            case 6 :  
//                System.out.println("Empty status = "+ bst.isEmpty());
//                break;     
            case 5: 
                bt.printPaths();
                System.out.print("\nPre order : ");
                bt.preOrder();
                System.out.print("\nIn order : ");
                bt.inOrder();
                System.out.print("\nPOst order : ");
                bt.postOrder();
                break;
            default : 
                System.out.println("masukkan angka 1- 7 \n ");
                break;   
            } 
            System.out.println("\nApakah mau lanjut? (Type y or n)\n");
            ch = scan.next().toLowerCase().charAt(0);                        
        } while (ch == 'y');               

    }
}
