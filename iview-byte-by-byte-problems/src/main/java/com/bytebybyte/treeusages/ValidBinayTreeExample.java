package com.bytebybyte.treeusages;

// Check if a given tree is valid binary tree
public class ValidBinayTreeExample {

    public static void main(String[] args) {
//        TreeNode root = BinarySearchTree.createBinaryTree(new int[]{10, 5, 6, 7, 8, 100, 5, 76, 1, 4, 5});
//        BinarySearchTree.levelOrderTraversalWithQueues(root);
//        System.out.print(isBinaryTree(root));

        //create a bad binary tree
//        TreeNode root = new TreeNode(6);
//        TreeNode tempNode = root;
//        for(int i=1, j=100; i<5; i++, j--) {
//            tempNode.left = new TreeNode(i);
//            tempNode.right = new TreeNode(j);
//            tempNode = tempNode.left;
//        }
//
//        BinarySearchTree.levelOrderTraversalWithQueues(root);
//        System.out.print(isBinaryTree(root));


    }

    private static boolean isBinaryTree(TreeNode root) {
        if (root == null)
            return true;

        if (isLeftSubtreeLesserThanParent(root.left, root.data) &&
                isRightSubtreeGreaterThanParent(root.right, root.data) &&
                isBinaryTree(root.left) &&
                isBinaryTree(root.right)) {
            System.out.println("isBinaryTree: true");
            return true;
        } else {
            System.out.println("isBinaryTree: false");
            return false;
        }
    }

    private static boolean isRightSubtreeGreaterThanParent(TreeNode root, int data) {
        if(root == null) {
            System.out.println("isRightSubtreeGreaterThanParent - Root Null : true");
            return true;
        }

        if(root.data > data &&
                isLeftSubtreeLesserThanParent(root.left, root.data) &&
                isRightSubtreeGreaterThanParent(root.right, root.data)){
            System.out.println("isRightSubtreeGreaterThanParent : true");
            return true;
        } else {
            System.out.println("isRightSubtreeGreaterThanParent : true");
            return false;
        }

    }

    private static boolean isLeftSubtreeLesserThanParent(TreeNode root, int data) {
        if(root == null) {
            System.out.println("isLeftSubtreeLesserThanParent - Root Null : true");
            return true;
        }

        if(root.data <= data &&
                isLeftSubtreeLesserThanParent(root.left, root.data) &&
                isRightSubtreeGreaterThanParent(root.right, root.data)){
            System.out.println("isLeftSubtreeLesserThanParent : true");
            return true;
        } else {
            System.out.println("isLeftSubtreeLesserThanParent : false");
            return false;
        }

    }


}

