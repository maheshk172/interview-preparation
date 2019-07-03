package com.bytebybyte.treeusages;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    public static TreeNode root;
    private static Queue<TreeNode> queue = new LinkedList<>();

    public static void add(int data) {
        if(root == null) {
            root = new TreeNode(data);
            return;
        } else {
            addNode(root, data);
        }
    }

    private static void addNode(TreeNode current, int data) {
        if(data <= current.data) {
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

    public static TreeNode createBinaryTree(int[] array) {
        Arrays.stream(array).forEach(BinarySearchTree::add);
        return BinarySearchTree.root;
    }

    // level order traversal with queue
    public static void levelOrderTraversalWithQueues(TreeNode root) {
        if(root != null) {
            queue.add(root);
            System.out.print("[ ");
            performLevelOrderTraversal();
            System.out.print(" ]");
        }
        System.out.println();
    }

    private static void performLevelOrderTraversal() {
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
            System.out.print(currentNode.data);
            System.out.print(queue.size() > 0 ? ", " : "");
        }
    }

    private static TreeNode getMinFromBinaryTree(TreeNode root) {
        if(root != null && root.left == null) {
            return root;
        } else {
            return getMinFromBinaryTree(root.left);
        }
    }

    private static TreeNode getMaxFromBinaryTree(TreeNode root) {
        if(root != null && root.right == null) {
            return root;
        } else {
            return getMaxFromBinaryTree(root.right);
        }
    }


    // with recursion
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ,");
        inOrderTraversal(node.right);
    }

    // In Order Traversal without recursion
    // With Stack
    public static void inOrderTraversalWithoutRecursion(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();


        TreeNode current = node;
        while (!stack.empty() || current != null) {

            while (current != null) {
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

    // Inorder without using queues:
    public static void levelTraversal(TreeNode root) {

        TreeNode current = root;
        int heightOfTree = getHeightOfTree(root);

        for (int i = 1; i <= heightOfTree; i++) {
            printGivenLevel(root, i);
        }
    }

    public static int getHeightOfTree(TreeNode root) {
        TreeNode current = root;

        if (root == null) {
            return 0;
        }

        int leftHeight = getHeightOfTree(root.left);
        int rightHeight = getHeightOfTree(root.right);

        if (leftHeight > rightHeight) return leftHeight + 1;
        else return rightHeight + 1;
    }

    private static void printGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static TreeNode deleteNode(TreeNode root, int number) {
        // first find the Nunber
        if(root == null) return null;

        if(root.data < number) {
            root.right = deleteNode(root.right, number);
        } else if(root.data > number){
            root.left = deleteNode(root.left, number);
        } else {
            // Found the match, lets delete number from tree

            //case 1: leaf node
            if(root.left == null && root.right == null) {
                root = null;
            } else if (root.left !=null && root.right == null) {
                // Case 2: has left Subtree but not right
                root = root.left;
            }  else if (root.left ==null && root.right != null) {
                // Case 2: has right Subtree but not left
                root = root.right;
            } else {
                //find min from right
                TreeNode minFromRight = getMinFromBinaryTree(root.right);
                System.out.print("Found Min from Right : " + minFromRight.data);
                root.data = minFromRight.data;
                root.right = deleteNode(root.right, minFromRight.data);
            }
        }

        //return root
        return root;
    }
}
