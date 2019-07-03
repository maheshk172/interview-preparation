package com.iview.datastructure.list.problems;

import com.iview.datastructure.list.LinkedList;
import com.iview.datastructure.list.impl.SingleLinkedList;
import com.iview.datastructure.list.models.Node;
import com.iview.datastructure.list.models.NodePositions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListProblemsTest {

    LinkedList list = null;

    @Before
    public void setUp() throws Exception {
        list = new SingleLinkedList();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void removeDuplicatesFromUnsortedList() throws Exception {
        int[] intArray = {10, 55, 12, 14, 10, 55, 14, 13, 11};
        LinkedList list = new SingleLinkedList();
        Node head = this.getListWithNodes(intArray);
        list.setHead(head);
        String dataList = list.fetchDataFromList();
        assertEquals("10, 55, 12, 14, 10, 55, 14, 13, 11", dataList);
        System.out.println("List before removal of duplicates: {" + dataList + "}");

        head = LinkedListProblems.removeDuplicatesFromUnsortedList(head);
        list.setHead(head);
        dataList = list.fetchDataFromList();
        assertEquals("10, 55, 12, 14, 13, 11", dataList);
        System.out.println("List before after of duplicates: {" + dataList + "}");
    }

    @Test
    public void removeDuplicatesFromUnsortedListWithHashmap() throws Exception{
        int[] intArray = {10, 55, 12, 14, 10, 55, 14, 13, 11};
        LinkedList list = new SingleLinkedList();
        Node head = this.getListWithNodes(intArray);
        list.setHead(head);
        String dataList = list.fetchDataFromList();
        assertEquals("10, 55, 12, 14, 10, 55, 14, 13, 11", dataList);
        System.out.println("List before removal of duplicates: {" + dataList + "}");

        head = LinkedListProblems.removeDuplicatesFromUnsortedListWithHashmap(head);
        list.setHead(head);
        dataList = list.fetchDataFromList();
        assertEquals("10, 55, 12, 14, 13, 11", dataList);
        System.out.println("List before after of duplicates: {" + dataList + "}");

    }

    @Test
    public void deleteNodeWhenThatSpecificNodeGiven() throws Exception {
        int[] intArray = {10, 55, 12, 14, 10, 55, 14, 13, 11};
        LinkedList list = new SingleLinkedList();
        Node head = this.getListWithNodes(intArray);
        list.setHead(head);
        String dataList = list.fetchDataFromList();
        System.out.println("List before deletion of node: {" + dataList + "}");
        Node n = list.getNode(head, 3);
        LinkedListProblems.deleteNodeWhenThatSpecificNodeGiven(n);

        list.setHead(head);
        dataList = list.fetchDataFromList();
        assertEquals("10, 55, 14, 10, 55, 14, 13, 11", dataList);
        System.out.println("List after deletion of node: {" + dataList + "}");
    }

    @Test
    public void splitListBasedOnPivotTest() throws Exception {
        int[] intArray = {10, 55, 12, 14, 10, 55, 14, 13, 11};
        LinkedList list = new SingleLinkedList();
        Node head = this.getListWithNodes(intArray);
        list.setHead(head);
        String dataList = list.fetchDataFromList();
        System.out.println("List before rearranging: {" + dataList + "}");

        // rearranging List
        head = LinkedListProblems.splitListBasedOnPivot(head, 15);

        list.setHead(head);
        dataList = list.fetchDataFromList();
        System.out.println("List after deletion of node: {" + dataList + "}");
        assertEquals("10, 12, 14, 10, 14, 13, 11, 55, 55", dataList);

    }

    /** Common Util methods **/
    public Node getListWithNodes(int[] intArray) throws Exception {
        for(int i=0; i<intArray.length; i++) {
            Node tempNode = new Node(intArray[i]);
            list.addNode(tempNode, NodePositions.POSITION_END);
        }
        return list.getHead();
    }

    public Node getListWithNodes(int n) throws Exception {
        // define the range
        int max = 100;
        int min = 1;
        int range = max - min + 1;

        // generate random numbers within 1 to 10
        for (int i = 0; i < n; i++) {
            int rand = (int) (Math.random() * range) + min;

            Node tempNode = new Node(rand);
            list.addNode(tempNode, NodePositions.POSITION_END);
        }
        return list.getHead();
    }

}