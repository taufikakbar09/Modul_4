package BTLab;

public class BinaryTree {

    public static NodeTree root;
    

    public BinaryTree() {
        this.root = null;
    }

    public void add(int a) {
        NodeTree baru = new NodeTree(a);
        if (root == null) {
            root = baru;
            return;
        }
        NodeTree current = root;
        NodeTree parent = null;
        while (true) {
            parent = current;
            if (a < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = baru;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = baru;
                    return;
                }
            }
        }
    }

    public void show(NodeTree root) {
        if (root != null) {
            show(root.left);
            System.out.print(" " + root.data);
            show(root.right);
        }
    }

    int getLeaf() {
        return getLeaf(root);
    }

    int getLeaf(NodeTree a) {
        if (a == null) {
            return 0;
        }
        if (a.left == null && a.right == null) {
            return 1;
        } else {
            return getLeaf(a.left) + getLeaf(a.right);
        }
    }
    void printPaths(){
        printPaths(root);
    }
    void printPaths(NodeTree node) 
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
  
    void printPathsRecur(NodeTree b, int path[], int pathLen) 
    {
        if (b == null)
            return;
  
        /* append this node to the path array */
        path[pathLen] = b.data;
        pathLen++;
  
        /* it's a leaf, so print the path that led to here */
        if (b.left == null && b.right == null)
            printArray(path, pathLen);
        else
            { 
            /* otherwise try both subtrees */
            printPathsRecur(b.left, path, pathLen);
            printPathsRecur(b.right, path, pathLen);
        }
    }
  
    void printArray(int ints[], int len) 
    {
        int i;
        for (i = 0; i < len; i++) 
            System.out.print("->"+ints[i]);
        System.out.println("");
    }
//    public find(int id) {
//        Node current = root;
//        while (current != null) {
//            if (current.data == id) {
//                return true;
//            } else if (current.data > id) {
//                current = current.left;
//            } else {
//                current = current.right;
//            }
//        }
//        return false;
//    }

    void preOrder(){
        preOrder(root);
    }
    void preOrder(NodeTree a) {
        if (a == null) {
            return;
        }
        System.out.print(a.data + " ");
        preOrder(a.left);
        preOrder(a.right);
    }
    
    void inOrder(){
        inOrder(root);
    }
    void inOrder(NodeTree a) {
        if (a == null) {
            return;
        }
        inOrder(a.left);
        System.out.print(a.data + " ");
        inOrder(a.right);
    }
    
    void postOrder(){
        postOrder(root);
    }
    void postOrder(NodeTree a) {
        if (a == null) {
            return;
        }
        postOrder(a.left);
        postOrder(a.right);
        System.out.print(a.data + " ");
    }
    public boolean delete(int id) {
        NodeTree parent = root;
        NodeTree current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //minimum elemen
            NodeTree successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public NodeTree getSuccessor(NodeTree deleleNode) {
        NodeTree successsor = null;
        NodeTree successsorParent = null;
        NodeTree current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }
     public void searchPaths(int x){
        searchGetPaths(root, x);
    }
    
    public void searchGetPaths(NodeTree root,int x){
        
            if(root.getData()<x){
            System.out.print(root.getData()+" ");
            searchGetPaths(root.getRight(), x);  
            }

            else if(root.getData()> x){
                System.out.print(root.getData()+" ");
                searchGetPaths(root.getLeft(), x);
            }

            else if(root.getData()== x){
                System.out.print(root.getData()+" ");
            }
        
    }
}
