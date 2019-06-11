package com.iview.datastructure.list;

import com.iview.datastructure.list.exceptions.NodeCantBeAddedException;
import com.iview.datastructure.list.exceptions.NodeCantBeDeletedException;
import com.iview.datastructure.list.exceptions.NodeCantBeRetrieved;
import com.iview.datastructure.list.models.Node;
import com.iview.datastructure.list.models.NodePositions;

public interface LinkedList {

    int getLength();
    Node getHead();

    void setHead(Node head);

    // Fetch Data From List
    String fetchDataFromList();
    Node getNode(Node head, int position) throws NodeCantBeRetrieved;

    Node addNode(Node node, NodePositions position) throws NodeCantBeAddedException;
    Node addNode(Node node, int position) throws NodeCantBeAddedException;

    Node deleteNode(Node node, NodePositions position) throws NodeCantBeDeletedException;
    Node deleteNode(Node node, int position) throws NodeCantBeDeletedException;
}
