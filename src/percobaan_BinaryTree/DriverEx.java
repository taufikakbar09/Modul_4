package percobaan_BinaryTree;

import javax.swing.tree.TreeNode;

import static percobaan_BinaryTree.BinaryEx.buildTree;

public class DriverEx {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 3, 5};
        int[] anotherArray = {1};
        TreeNode root = (TreeNode) buildTree(array);
     //   TreeNode anotherRoot = buildTree(anotherArray);
        
    }
}
