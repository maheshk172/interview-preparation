package com.bytebybyte.basic.linkedList;

public class SingleLinkedList {
    private Node head;
    private Node tail;

    public void add(int data) {
        Node node = new Node(data);
        add(node);
    }

    public void add(Node node) {
        if(head == null && tail == null) {
            head = node;
            tail = head;
        }

        tail.next = node;
        tail = node;
    }


    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return tail;
    }

    // Static method, added for singnificance
    public static String printList(Node head) throws Exception {
        Node currentNode = head;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int nodeCount = 0;

        while (currentNode != null) {
            builder.append("{ Node-")
                    .append(nodeCount)
                    .append(":")
                    .append(currentNode.data)
                    .append(" }");
            currentNode = currentNode.next;

            if(currentNode != null)
                builder.append(", ");

            nodeCount++;
            // Added for testing
            if(nodeCount > 200) {
                System.out.println("This seem to be a Circular List");
                throw new Exception("This is a circular List");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
