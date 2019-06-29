package com.bytebybyte.basic;

import java.util.Stack;

/**
 * Insertion order
 * 10, 5, 13, 4, 8, 11
 *
 * In Order Traversal
 * 4 ,5 ,8 ,10 ,11 ,13
 *
 * Pre Order Traversal
 * 10 ,5 ,4 ,8 ,13 ,11
 *
 * Post Order Traversal
 * 4 ,8 ,5 ,11 ,13 ,10
 *
 *
 */
public class BinarySearchTreeExample {

    public static void main(String[] args) {

        BinarySearchTree.add(10);
        BinarySearchTree.add(5);
        BinarySearchTree.add(13);
        BinarySearchTree.add(4);
        BinarySearchTree.add(8);
        BinarySearchTree.add(11);

        TreeNode root = BinarySearchTree.root;

        //InOrder Traverdsal
        System.out.println("In Order Traversal");
        inOrderTraversal(root);
        System.out.println("");
//        System.out.println("Pre Order Traversal");
//        preOrderTraversal(root);
//        System.out.println("");
//        System.out.println("Post Order Traversal");
//        postOrderTraversal(root);

//        System.out.println("In Order Traversal without recursion");
//        inOrderTraversalWithoutRecursion(root);

          System.out.println("Level or bredth first traversal");
          levelTraversal(root);

    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ,");
        inOrderTraversal(node.right);
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ,");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ,");
    }

    // In Order Traversal without recursion
    // With Stack
    public static void inOrderTraversalWithoutRecursion(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();


        TreeNode current = node;
        while(!stack.empty() || current != null) {

            while(current != null) {
                stack.push(current);
                current = current.right;
            }

            // all left done, pop now
            current = stack.pop();
            System.out.println(current.data);

            // lets visit right subtree
            current = current.left;
        }
    }

    public static void levelTraversal(TreeNode root) {

        TreeNode current = root;
        int heightOfTree = getHeightOfTree(root);

        for(int i=1; i<=heightOfTree; i++) {
            printGivenLevel(root, i);
        }
    }

    public static int getHeightOfTree(TreeNode root) {
        TreeNode current  =  root;

        if(root == null) {
            return 0;
        }

        int leftHeight = getHeightOfTree(root.left);
        int rightHeight = getHeightOfTree(root.right);

        if(leftHeight > rightHeight) return leftHeight + 1;
        else return rightHeight + 1;
    }

    public static void printGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }


}


class TreeNode {
    public final int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    public static TreeNode root;

    public static void add(int data) {
        if(root == null) {
            root = new TreeNode(data);
            return;
        } else {
            addNode(root, data);
        }
    }

    private static void addNode(TreeNode current, int data) {
        if(data < current.data) {
            if(current.left == null) {
                current.left = new TreeNode(data);
            } else {
                addNode(current.left, data);
            }
        } else {
            if(current.right == null) {
                current.right = new TreeNode(data);
            } else {
                addNode(current.right, data);
            }
        }
    }
}