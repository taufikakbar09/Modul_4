package BTLab;

public class NodeTree {

    int data;
    NodeTree left;
    NodeTree right;

    public NodeTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public NodeTree getLeft() {
        return left;
    }

    public NodeTree getRight() {
        return right;
    }
}
