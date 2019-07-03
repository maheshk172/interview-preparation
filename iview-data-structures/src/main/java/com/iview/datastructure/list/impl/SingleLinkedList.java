package com.iview.datastructure.list.impl;

import com.iview.datastructure.list.LinkedList;
import com.iview.datastructure.list.exceptions.NodeCantBeAddedException;
import com.iview.datastructure.list.exceptions.NodeCantBeDeletedException;
import com.iview.datastructure.list.exceptions.NodeCantBeRetrieved;
import com.iview.datastructure.list.models.Node;
import com.iview.datastructure.list.models.NodePositions;

public class SingleLinkedList implements LinkedList {

    private Node head;
    public int length = 0;

    public SingleLinkedList() {
    }


    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public void setHead(Node head) {
        this.head = head;
    }

    // Fetch Data From List
    @Override
    public String fetchDataFromList() {
        StringBuffer listString = new StringBuffer();

        Node tempNode = head;
        while (tempNode != null) {
            listString.append(tempNode.data);
            tempNode = tempNode.nextNode;

            if (tempNode != null) {
                listString.append(", ");
            }
        }
        return listString.toString();
    }

    @Override
    public Node getNode(Node head, int position) throws NodeCantBeRetrieved {
//        if(position > length)
//            throw new NodeCantBeRetrieved("Position requested is greater than length of list");
        Node tempNode = head;
        for(int i=0; i< position-1; i++) {
            tempNode = tempNode.nextNode;
        }

        return tempNode;
    }


    @Override
    public Node addNode(Node node, NodePositions position) throws NodeCantBeAddedException {

        switch (position) {
            case POSITION_START:
                return addNodeAtStart(node);
            case POSITION_END:
            default:
                return addNodeAtEnd(node);

        }
    }

    @Override
    public Node addNode(Node node, int position) throws NodeCantBeAddedException {

        if (position < length) {
            int i = 0;
            Node tempNode = head;
            while (i < position && tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                i = i + 1;
            }

            node.nextNode = tempNode.nextNode;
            tempNode.nextNode = node;
            length += 1;
        } else {
            throw new NodeCantBeAddedException("position is incorrect");
        }

        return head;
    }

    @Override
    public Node deleteNode(Node head, NodePositions position) throws NodeCantBeDeletedException {
        switch (position) {
            case POSITION_START:
                return deleteNodeAtStart(head);
            case POSITION_END:
            default:
                return deleteNodeAtEnd(head);
        }
    }

    private synchronized Node deleteNodeAtStart(Node head) throws NodeCantBeDeletedException{

        if(head == null)
            throw new NodeCantBeDeletedException("List is Empty");
        System.out.println("Deleting node with data: " + head.data);

        head = head.nextNode;
        length = length - 1;
        return head;
    }

    private synchronized Node deleteNodeAtEnd(Node head) throws NodeCantBeDeletedException {
        if(head == null)
            throw new NodeCantBeDeletedException("List is Empty");
        Node prevNode = head;
        Node tempNode = prevNode.nextNode;

        while(tempNode.nextNode != null) {
            prevNode = prevNode.nextNode;
            tempNode = tempNode.nextNode;
        }

        //delete tempNode
        prevNode.nextNode = null;
        length = length - 1;
        System.out.println("Deleting node with data: " + tempNode.data);

        return head;
    }

    public synchronized Node deleteNode(Node head, int position) throws NodeCantBeDeletedException {

//        if(position > length)
//            throw new NodeCantBeDeletedException("Index requested is not valid, list length is: " + length);

        int i = 1;
        Node tempNode = head;

        while(i < position - 1) {
            tempNode = tempNode.nextNode;
            i++;
        }
        length = length - 1;
        System.out.println("Deleting Node with data : [" + tempNode.nextNode.data + "] at index {" + position +"}");
        tempNode.nextNode = tempNode.nextNode.nextNode;

        return head;
    }



    private synchronized Node addNodeAtStart(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.nextNode = head;
            head = node;
        }
        length += 1;
        return head;
    }

    private synchronized Node addNodeAtEnd(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node tempNode = head;
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = node;
        }
        length += 1;
        return head;
    }
}
