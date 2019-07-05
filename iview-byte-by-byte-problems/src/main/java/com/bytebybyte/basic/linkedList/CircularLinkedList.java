package com.bytebybyte.basic.linkedList;

import java.util.Random;

/**
 * Given a linked list, determine whether it contains a cycle.
 */
public class CircularLinkedList {

    public static void main(String[] args) {

        try {
            //Node head1 = populateListWithData(100);
            //System.out.println(SingleLinkedList.printList(head1));

            //findDuplicates(head1);

            Node head2 = createCircularList();
            //System.out.println(SingleLinkedList.printList(head2));

            findDuplicates(head2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findDuplicates(Node head){
        Node currentNode = head;
        Node jumper = head;
        boolean circular = false;
//        while(currentNode != null && jumper.next.next != null) {
//            if(currentNode == jumper.next) {
//                System.out.println("This is a circular List : " + currentNode.data);
//                circular = true;
//                break;
//
//            }
//            currentNode = currentNode.next;
//            jumper = jumper.next.next;
//        }
//        if(circular == false)
//            System.out.println("No Circular Loops found, this is pure list");

        while (jumper != null && jumper.next != null) {
            if (currentNode == jumper) {
                circular=true;
                break;
            }
            jumper = jumper.next.next;
            currentNode = currentNode.next;
        }

        if(circular == false) {
            System.out.println("No Circular Loops found, this is pure list");
        } else {
            System.out.println("This is a circular List : " + currentNode.data);
        }
    }


    static Node populateListWithData(int count) {
        DoublyLinkedList list = new DoublyLinkedList();
        Random random = new Random();

        for(int i=0; i<count; i++) {
            int tempRand = random.nextInt(Integer.MAX_VALUE);
            list.add(tempRand);
        }

        return list.getHead();
    }

    static Node createCircularList() {
        SingleLinkedList list = new SingleLinkedList();

        list.add(10);
        list.add(20);
        Node taintNode1 = new Node(30);
        list.add(taintNode1);
        list.add(40);
        //Node tail1 = list.getTail();
        list.add(50);
        list.add(60);
        list.add(70);
        Node taintNode2 = new Node(80);
        list.add(taintNode2);
        list.add(90);
        Node taintNode3 = new Node(100);
        list.add(taintNode3);

        //tail1.next = taintNode1;
        //taintNode3.next = taintNode2;

        list.getTail().next = taintNode1;

        return list.getHead();
    }

}





