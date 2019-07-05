package com.iview.transferwise;

import java.util.Arrays;
import java.util.List;

public class preOrderTraversalAndCompare {
    public static TreeNode root = null;

    public static void main(String[] args) {
        Integer[] array = {1, 3, 2, 1, 5, 4, 6};
        List<Integer> list = Arrays.asList(array);
        System.out.println(isValid(list));
    }


    public static String isValid(List<Integer> items) {
        // Creating PreOrder Traverasal
        StringBuffer buffer = new StringBuffer();
        addNodesToTree(items);
        preOrderTraversal(buffer, root);
        String preOrderTraversalList = buffer.toString();
        System.out.println("PreOrder traversed items:" + preOrderTraversalList);
        System.out.println("input items: " + printList(items));
        if(preOrderTraversalList.equals(printList(items))){
            return "YES";
        } else {
            return "NO";
        }
    }

    public static String printList(List<Integer> list) {
        StringBuffer buff = new StringBuffer();

        for(Integer i: list) {
            buff.append(i).append(",");
        }

        return buff.toString();
    }



    public static void preOrderTraversal(StringBuffer buffer, TreeNode root) {
        if(root != null) {
            buffer.append(root.data).append(",");
            preOrderTraversal(buffer, root.left);
            preOrderTraversal(buffer, root.right);
        }
    }



    public static void addNodesToTree(List<Integer> items) {
        for (int i = 0; i < items.size(); i++) {
            addNode(items.get(i));
        }
    }

    public static void addNode(Integer data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            insertNode(root, data);
        }
    }

    public static void insertNode(TreeNode current, Integer data) {
        if(data < current.data) {
            if(current.left == null) {
                current.left = new TreeNode(data);
            } else {
                insertNode(current.left, data);
            }
        } else {
            if(current.right == null) {
                current.right = new TreeNode(data);
            } else {
                insertNode(current.right, data);
            }
        }
    }


}

class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;
    Integer data;

    public TreeNode(Integer data) {
        this.data = data;
    }
}
