package com.bytebybyte.treeusages;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Insertion order
 * 10, 5, 13, 4, 8, 11
 * <p>
 * In Order Traversal
 * 4 ,5 ,8 ,10 ,11 ,13
 * <p>
 * Pre Order Traversal
 * 10 ,5 ,4 ,8 ,13 ,11
 * <p>
 * Post Order Traversal
 * 4 ,8 ,5 ,11 ,13 ,10
 */
public class BinarySearchTreeExample {

     private static Queue<TreeNode> queue = new LinkedList<>();

    public static void main(String[] args) {

//        BinarySearchTree.add(10);
//        BinarySearchTree.add(5);
//        BinarySearchTree.add(13);
//        BinarySearchTree.add(4);
//        BinarySearchTree.add(8);
//        BinarySearchTree.add(11);
//        BinarySearchTree.add(11);
//        BinarySearchTree.add(11);
//        BinarySearchTree.add(11);
//        BinarySearchTree.add(11);

//        int[] array = {10, 4, 5, 6, 11, 3, 2, 11, 56, 1, 7, 9, 20};
//
//        TreeNode root =  BinarySearchTree.createBinaryTree(array);

          // InOrder Traverdsal
//        System.out.println("In Order Traversal");
//        inOrderTraversal(root);
//        System.out.println("");
//        System.out.println("Pre Order Traversal");
//        preOrderTraversal(root);
//        System.out.println("");
//        System.out.println("Post Order Traversal");
//        postOrderTraversal(root);

//        System.out.println("In Order Traversal without recursion");
//        inOrderTraversalWithoutRecursion(root);

//        System.out.println("Level or bredth first traversal");
//        BinarySearchTree.levelTraversal(root);
//
//        System.out.println("Level or bredth first traversal with queues");
//        BinarySearchTree.levelOrderTraversalWithQueues(root);


        // Test Deletion of the node
        int[] array = {10, 4, 5, 6, 11, 3, 2, 12, 56, 1, 7, 9, 20};
        TreeNode root =  BinarySearchTree.createBinaryTree(array);
        System.out.println("Before deletion");
        BinarySearchTree.levelOrderTraversalWithQueues(root);

        //Delete 11
        int numberToDelete = 11;
        root = BinarySearchTree.deleteNode(root, numberToDelete);
        System.out.println("After deletion : " + numberToDelete);
        BinarySearchTree.levelOrderTraversalWithQueues(root);

        numberToDelete = 56;
        root = BinarySearchTree.deleteNode(root, numberToDelete);
        System.out.println("After deletion : " + numberToDelete);
        BinarySearchTree.levelOrderTraversalWithQueues(root);

        numberToDelete = 10;
        root = BinarySearchTree.deleteNode(root, numberToDelete);
        System.out.println("After deletion : " + numberToDelete);
        BinarySearchTree.levelOrderTraversalWithQueues(root);

        numberToDelete = 3;
        root = BinarySearchTree.deleteNode(root, numberToDelete);
        System.out.println("After deletion : " + numberToDelete);
        BinarySearchTree.levelOrderTraversalWithQueues(root);

    }



}


