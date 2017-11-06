package percobaan_BinaryTree;

public class BinaryTree {

    Node root;

    void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    // Removes all nodes with only one child and returns
    // new root (note that root may change)
    Node RemoveHalfNodes(Node node) {
        if (node == null) {
            return null;
        }

        node.left = RemoveHalfNodes(node.left);
        node.right = RemoveHalfNodes(node.right);

        if (node.left == null && node.right == null) {
            return node;
        }

        /* if current nodes is a half node with left
         child NULL left, then it's right child is
         returned and replaces it in the given tree */
        if (node.left == null) {
            Node new_root = node.right;
            return new_root;
        }

        /* if current nodes is a half node with right
           child NULL right, then it's right child is
           returned and replaces it in the given tree  */
        if (node.right == null) {
            Node new_root = node.left;
            return new_root;
        }

        return node;
    }
}
