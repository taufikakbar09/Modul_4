/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percobaan_BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryEx {

    // TreeNode class
    private static class TreeNode {

        int val;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int i) {
            this.val = i;
            this.leftNode = null;
            this.rightNode = null;
        }

        public TreeNode(Object object) {
        }
    }

    // build a binary tree by an array
    public static TreeNode buildTree(int[] array) {
        if (array.length == 1) {
            return new TreeNode(array[0]);
        }
        List<TreeNode> list = new LinkedList<TreeNode>();
        for (int i = 0; i < array.length; i++) {
            list.add(new TreeNode(array[i]));
        }
        for (int i = 0; i < array.length / 2 - 1; i++) {
            list.get(i).leftNode = list.get(2 * i + 1);
            list.get(i).rightNode = list.get(2 * i + 2);
        }
        if (array.length % 2 == 0) {
            list.get(array.length / 2 - 1).leftNode = list.get(list.size() - 1);
        } else {
            list.get(array.length / 2 - 1).leftNode = list.get(list.size() - 2);
            list.get(array.length / 2 - 1).rightNode = list.get(list.size() - 1);
        }
        return list.get(0);
    }

    // get the number of nodes in the tree (REC)
    public static int getNumber(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNumber(root.leftNode) + getNumber(root.rightNode) + 1;
    }

    // get the number of nodes in the tree (non-REC), use Queue
    public static int getNumberNonREC(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode currentNode = list.remove();
            if (currentNode.leftNode != null) {
                list.add(currentNode.leftNode);
                count++;
            }
            if (currentNode.rightNode != null) {
                list.add(currentNode.rightNode);
                count++;
            }
        }
        return count;
    }

    // get the depth of the tree(REC)
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getDepth(root.leftNode), getDepth(root.rightNode)) + 1;
        }
    }

    // get the depth of the tree(non-REC), use Queue
    public static int getDepthNonREC(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0, currentLevelNums = 1, nextLevelNums = 0;
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode curr = list.remove();
            currentLevelNums--;
            if (curr.leftNode != null) {
                list.add(curr.leftNode);
                nextLevelNums++;
            }
            if (curr.rightNode != null) {
                list.add(curr.rightNode);
                nextLevelNums++;
            }
            if (currentLevelNums == 0) {
                currentLevelNums = nextLevelNums;
                nextLevelNums = 0;
                depth++;
            }
        }
        return depth;

    }

    // pre-order traverse(REC)
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.val);
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    // pre-order traverse(non-REC), use Stack
//    public static void preOrderNonREC(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode current = root;
//        while (current != null || !stack.isEmpty()) {
//            if (current != null) {
//                stack.push(current);
//                System.out.print(current.val);
//                current = current.leftNode;
//            } else {
//                current = stack.pop();
//                current = current.rightNode;
//            }
//        }
//    }

    // in-order traverse(REC)
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftNode);
        System.out.print(" " + root.val);
        inOrder(root.rightNode);
    }

    // in-order traverse(non-REC)
//    public static void inOrderNonREC(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode current = root;
//        while (current != null || !stack.isEmpty()) {
//            if (current != null) {
//                stack.push(current);
//                current = current.leftNode;
//            } else {
//                current = stack.pop();
//                System.out.print(current.val);
//                current = current.rightNode;
//            }
//        }
//    }

    // post-order traverse(REC)
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(" " + root.val);
    }

    // post-order traverse(non-REC)
//    public static void postOrderNonREC(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        Stack<TreeNode> outPut = new Stack<TreeNode>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode current = stack.pop();
//            outPut.push(current);
//            if (current.leftNode != null) {
//                stack.push(current.leftNode);
//            }
//            if (current.rightNode != null) {
//                stack.push(current.rightNode);
//            }
//        }
//        while (!outPut.isEmpty()) {
//            System.out.print(outPut.pop().val);
//        }
//    }

    // level traverse (non-REC) rec method is pretty rare.
    public static void levelTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val);
            if (current.leftNode != null) {
                queue.add(current.leftNode);
            }
            if (current.rightNode != null) {
                queue.add(current.rightNode);
            }
        }
    }

    // return the number of kth depth of the tree(REC)
    public static int getNumberOfKthLevel(TreeNode root, int k) {
        if (root == null) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else {
            int leftNodes = getNumberOfKthLevel(root.leftNode, k - 1);
            int rightNodes = getNumberOfKthLevel(root.rightNode, k - 1);
            return leftNodes + rightNodes;
        }
    }

    // return the number of kth depth of the tree(non-REC)
    public static int getNumberOfKthLevelNonREC(TreeNode root, int k) {
        if (root == null || k == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currentDepth = 1;
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;
        while (!queue.isEmpty() && currentDepth < k) {
            TreeNode curr = queue.remove();
            currentLevelNodes--;
            if (curr.leftNode != null) {
                queue.add(curr.leftNode);
                nextLevelNodes++;
            }
            if (curr.rightNode != null) {
                queue.add(curr.rightNode);
                nextLevelNodes++;
            }
            if (currentLevelNodes == 0) {
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                currentDepth++;
            }
        }
        return currentLevelNodes;
    }

    // return the number of leaf(REC)
    public static int getLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.leftNode == null && root.rightNode == null) {
            return 1;
        }
        return getLeaf(root.leftNode) + getLeaf(root.rightNode);
    }

    // return the number of leaf(non-REC)
    public static int getLeafNonREC(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int leaf = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr.leftNode != null) {
                queue.add(curr.leftNode);
            }
            if (curr.rightNode != null) {
                queue.add(curr.rightNode);
            }
            if (curr.leftNode == null && curr.rightNode == null) {
                leaf++;
            }
        }
        return leaf;
    }

    public static int findPath(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (sum == root.val) {
            res++;
        }
        res += findPath(root.leftNode, sum - root.val);
        res += findPath(root.rightNode, sum - root.val);
        return res;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 1, 4, 9, 11, 12};
        int[] anotherArray = {1};
        TreeNode root = buildTree(array);
        TreeNode anotherRoot = buildTree(anotherArray);
//         System.out.println(getNumber(root));
//         System.out.println(getNumberNonREC(root));
//         System.out.println(getDepth(root));
//         System.out.println(getDepthNonREC(root));
         preOrder(root);
         System.out.println("");
//         preOrderNonREC(root);
//         System.out.println("");
         inOrder(root);
         System.out.println("");
//         inOrderNonREC(root);
//         System.out.println("");
         postOrder(root);
         System.out.println("");
//         postOrderNonREC(root);
//         System.out.println(" ");
         findPath(root, 2);
         System.out.println("");
//         levelTraverse(root);
//         System.out.println(getNumberOfKthLevel(root, 3));
//         System.out.println(getNumberOfKthLevelNonREC(root, 3));
//         System.out.println(getLeaf(anotherRoot));
//         System.out.println(getLeafNonREC(anotherRoot));


    }
}
