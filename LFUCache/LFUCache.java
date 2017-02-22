package LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by whong53 on 2/22/17.
 */
public class LFUCache {

    private class Node {
        int count = 0;
        LinkedHashSet<Integer> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new LinkedHashSet<>();
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private int capacity = 0;
    private HashMap<Integer, Integer> valueHash;
    private HashMap<Integer, Node> nodeHash;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueHash = new HashMap<>();
        nodeHash = new HashMap<>();
    }

    public int get(int key) {
        if (valueHash.containsKey(key)) {
            increaseCount(key);
            return valueHash.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if (valueHash.size() < capacity) {
                valueHash.put(key, value);
            } else {
                removeLF();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }

    private void removeLF() {
        if (head == null) {
            return;
        }
        int toDelete = 0;
        for (int key : head.keys) {
            toDelete = key;
            break;
        }
        head.keys.remove(toDelete);
        if (head.keys.size() == 0) {
            remove(head);
        }
        nodeHash.remove(toDelete);
        valueHash.remove(toDelete);
    }

    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeHash.put(key, head);
    }

    private void increaseCount(int key) {
        Node node = nodeHash.get(key);
        node.keys.remove(key);
        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node toInsert = new Node(node.count + 1);
            toInsert.keys.add(key);
            toInsert.prev = node;
            toInsert.next = node.next;
            node.next.prev = toInsert;
            node.next = toInsert;
        }
        nodeHash.put(key, node.next);
        if (node.keys.size() == 0) {
            remove(node);
        }
    }

    private void remove(Node node) {
        if (node.prev == null) {
            // node is head, assign head to node.next;
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
}
