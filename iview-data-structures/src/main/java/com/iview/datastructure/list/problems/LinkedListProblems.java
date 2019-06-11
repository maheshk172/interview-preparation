package com.iview.datastructure.list.problems;

import com.iview.datastructure.list.models.Node;

import java.util.HashMap;

public class LinkedListProblems {


    /* Problem: Remove Duplicates from an unsorted List
     *
     */
    public static Node removeDuplicatesFromUnsortedList(Node head) throws Exception {
        Node currentNode = head;
        int currentData;

        while (currentNode.nextNode != null) {
            Node nextNode = currentNode.nextNode;
            Node prevNode = currentNode;

            currentData = currentNode.data;

            while (nextNode != null) {
                if (nextNode.data == currentData) {
                    System.out.println("Deleting Node with data : " + currentData);
                    prevNode.nextNode = nextNode.nextNode;
                }
                prevNode = prevNode.nextNode;
                nextNode = nextNode.nextNode;
            }
            currentNode = currentNode.nextNode;
        }
        return head;
    }

    // Using Hashmap here to maintain copy of unique list, which we can compare
    //
    public static Node removeDuplicatesFromUnsortedListWithHashmap(Node n) throws Exception {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Node head = n;
        Node previousNode = null;
        while (n != null) {
            int data = n.data;
            if (hashMap.containsKey(data)) {
                hashMap.put(data, hashMap.get(data) + 1);
                previousNode.nextNode = n.nextNode;
            } else {
                hashMap.put(data, 1);
                previousNode = n;
            }
            n = n.nextNode;
        }
        return head;
    }

    // Delete node, if access givento that node only
    // head -> a -> b -> c -> d
    // delete c
    public static boolean deleteNodeWhenThatSpecificNodeGiven(Node node) {
        if (node == null || node.nextNode == null) {
            return false;
        }
        node.data = node.nextNode.data;
        node.nextNode = node.nextNode.nextNode;

        return  true;
    }

    // Split the List into two sections, one which is less than X and other which is greater than x

    public static Node splitListBasedOnPivot(Node head, int pivot) throws Exception {
        if(head == null)
            throw new Exception("List is empty");
        Node tempNode = head;
        Node lessThanListHead = null;
        Node greaterThanListHead = null;
        Node lessThanListLastNode = null;
        Node greaterThanListLastNode = null;

        while (tempNode != null) {
            if(tempNode.data < pivot) {
                if(lessThanListLastNode == null) {
                    lessThanListLastNode = new Node(tempNode.data);
                    lessThanListHead = lessThanListLastNode;
                } else {
                    lessThanListLastNode.nextNode = new Node(tempNode.data);
                    lessThanListLastNode = lessThanListLastNode.nextNode;
                }
            } else {
                if(greaterThanListLastNode == null) {
                    greaterThanListLastNode = new Node(tempNode.data);
                    greaterThanListHead = greaterThanListLastNode;
                } else {
                    greaterThanListLastNode.nextNode = new Node(tempNode.data);
                    greaterThanListLastNode = greaterThanListLastNode.nextNode;
                }
            }
            tempNode = tempNode.nextNode;
        }

        lessThanListLastNode.nextNode = greaterThanListHead;

        return lessThanListHead;
    }
}
