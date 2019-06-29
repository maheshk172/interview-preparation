package com.bytebybyte.basic;

import java.nio.channels.Pipe;

public class PriorityQueueExample {
    public static void main(String[] args) {

        QueueNode<Integer> node1 = new QueueNode<Integer>(10, QueuePriority.LOW_PRIORITY);
        QueueNode<Integer> node2 = new QueueNode<Integer>(11, QueuePriority.HIGH_PRIORITY);
        QueueNode<Integer> node3 = new QueueNode<Integer>(12, QueuePriority.HIGH_PRIORITY);
        QueueNode<Integer> node4 = new QueueNode<Integer>(13, QueuePriority.MEDIUM_PRIORITY);
        QueueNode<Integer> node5 = new QueueNode<Integer>(14, QueuePriority.LOW_PRIORITY);

        PriorityQueue.push(node1);
        PriorityQueue.push(node2);
        PriorityQueue.push(node3);
        PriorityQueue.push(node4);
        PriorityQueue.push(node5);

        while (!PriorityQueue.isEmpty()) {
            node1 = PriorityQueue.pop();
            if(node1 != null) {
                System.out.println("Node Data: " + node1.data + ", priority: " + node1.priority);
            }
        }

    }
}

class PriorityQueue {
    private static QueueNode<Integer> head;
    private static QueueNode<Integer> tail ;

    public static boolean isEmpty() {
        return head == null;
    }

    public static boolean push(QueueNode<Integer> node) {
        if(head == null && tail == null) {
            head = node;
            tail = node;
            head.next = tail;
            tail.next = null;
            return true;
        }

        if(node.compareTo(head) == 1 || node.compareTo(head) == 0) {
            node.next = head;
            head = node;
            return true;
        } else {
            QueueNode tempNode = head;
            QueueNode prevNode = head;

            while(tempNode != tail) {
                if(node.compareTo(tempNode) == 1) {
                    node.next = tempNode;
                    prevNode.next = node;
                    break;
                }
                prevNode = prevNode.next;
                tempNode = tempNode.next;
            }
            if(tail.compareTo(node) == 1) {
                prevNode.next = node;
                node.next = tail;
            } else {
                tail.next = node;
                tail = node;
            }
            return true;
        }

    }

    public static QueueNode<Integer> pop() {
        if(head == null)
            return null;

        QueueNode<Integer> node = head;
        head = head.next;
        return node;
    }

}

class QueueNode<T>{
    T data;
    QueuePriority priority;
    QueueNode<T> next;

    public QueueNode(T data, QueuePriority priority) {
        this.data = data;
        this.priority = priority;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPriority(QueuePriority priority) {
        this.priority = priority;
    }



    public int compareTo(QueueNode o) {
        if(this.priority.getPriority() < ((QueueNode)o).priority.getPriority()) {
            return 1;
        } else if(this.priority.getPriority() > ((QueueNode)o).priority.getPriority()) {
            return -1;
        } else {
            return 0;
        }
    }
}

enum QueuePriority {
    LOW_PRIORITY(5),
    MEDIUM_PRIORITY(3),
    HIGH_PRIORITY(1);

    private int priority;

    QueuePriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}

