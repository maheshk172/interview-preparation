package com.iview.datastructure.list.models;

import java.util.Objects;

public class Node implements Comparable <Node> {
    public int data;
    public Node nextNode = null;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return data == node.data &&
                nextNode.equals(node.nextNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nextNode);
    }


    @Override
    public int compareTo(Node obj) {
        if(this.data > obj.data)
            return 1;
        else if(this.data < obj.data)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
