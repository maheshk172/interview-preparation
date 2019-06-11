package com.iview.datastructure.list.impl;

import com.iview.datastructure.list.LinkedList;
import com.iview.datastructure.list.exceptions.NodeCantBeDeletedException;
import com.iview.datastructure.list.impl.SingleLinkedList;
import com.iview.datastructure.list.models.Node;
import com.iview.datastructure.list.models.NodePositions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListTest {

    Node head = null;
    LinkedList list = null;
    @Before
    public void setUp() throws Exception {
        list = new SingleLinkedList();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fetchDataFromList() throws Exception {
        //try with 5 elements
        int[] intArray = {1, 10, 22, 33, 55};

        Node head = this.getListWithNodes(intArray);
        list.setHead(head);
        String listString = list.fetchDataFromList();
        assertEquals("1, 10, 22, 33, 55", listString);
    }

    @Test
    public void addOneNodeAtStartTest() {
        Node node = new Node(10);
        try {
            head = list.addNode(node, NodePositions.POSITION_START);

            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals("10", listString);
            assertEquals(1, list.getLength());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void addOneNodeAtStartWithListOfTenNodesTest() {

        try {
            int[] intArray = {10, 20, 30, 40, 50};
            head = this.getListWithNodes(intArray);

            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals("10, 20, 30, 40, 50", listString);

            Node node = new Node(5);
            list.addNode(node, NodePositions.POSITION_START);
            listString = list.fetchDataFromList();
            assertEquals("5, 10, 20, 30, 40, 50", listString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void addOneNodeAtEndTest() {
        Node node = new Node(10);
        try {
            head = list.addNode(node, NodePositions.POSITION_END);

            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals("10", listString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void addOneNodeAtEndWithListOfTenNodesTest() {
        try {
            int[] intArray = {10, 20, 30, 40, 50};
            head = this.getListWithNodes(intArray);

            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals(listString, "10, 20, 30, 40, 50");

            Node node = new Node(60);
            list.addNode(node, NodePositions.POSITION_END);
            listString = list.fetchDataFromList();
            assertEquals("10, 20, 30, 40, 50, 60", listString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void deleteNodeAtStartWithOneNode() {
        try {
            int[] intArray = {10};
            head = this.getListWithNodes(intArray);

            head = this.list.deleteNode(head, NodePositions.POSITION_START);
            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals("", listString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void deleteNodeAtStartWithManyNode() {
        try {
            int[] intArray = {10, 20, 30};
            head = this.getListWithNodes(intArray);

            head = this.list.deleteNode(head, NodePositions.POSITION_START);
            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals(listString, "20, 30");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void deleteNodeAtEndWithManyNode() {
        try {
            int[] intArray = {10, 20, 30};
            head = this.getListWithNodes(intArray);

            head = this.list.deleteNode(head, NodePositions.POSITION_END);
            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals(listString, "10, 20");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void deleteNodeAtEndWithOneNode() {
        try {
            int[] intArray = {10};
            head = this.getListWithNodes(intArray);

            head = this.list.deleteNode(head, NodePositions.POSITION_END);
            list.setHead(head);
            String listString = list.fetchDataFromList();
            assertEquals("", listString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void deleteNodeAtIndexWithManyNodes() throws Exception{
        int[] intArray = {10, 20, 30, 40, 50};
        head = this.getListWithNodes(intArray);

        head = this.list.deleteNode(head, 2);
        list.setHead(head);
        String listString = list.fetchDataFromList();
        assertEquals("10, 30, 40, 50", listString);
    }

    @Test
    public void deleteNodeAtIndexNoNodes() throws Exception{
        int[] intArray = {};
        head = this.getListWithNodes(intArray);

        try {
            head = this.list.deleteNode(head, 2);
        } catch (NodeCantBeDeletedException ex) {
            assertEquals("Index requested is not valid, list length is: 0", ex.getMessage());
        }

    }

    @Test
    public void deleteNodeAtSecondPostionWithOnlyOneNodes() throws Exception{
        int[] intArray = {10};
        head = this.getListWithNodes(intArray);

        try {
            head = this.list.deleteNode(head, 2);
        } catch (NodeCantBeDeletedException ex) {
            assertEquals("Index requested is not valid, list length is: 1", ex.getMessage());
        }

    }


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