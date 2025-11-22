/**
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Algorithm:
 * Take a hashmap. key will be key, value will be the node
 * Node will have key and value
 * Most recently used key will be the first node, least recently used will be the last.
 * We will always insert new nodes at the first, since adding means accessing
 * Whenever a key is used, we will move it to first
 * Whenever a key is updated, again we will move it to first
 * When capacity is exceeded, evict the node at the tail (least recently used) and remove its key from the HashMap
 */

import java.util.HashMap;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}

class DoublyLinkedList {
    Node head, tail;
    int size;

    DoublyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void addFirst(int key, int value) {
        Node newNode = new Node(key, value);
        if(head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if(head == null) return;
        if(size == 1) {
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if(tail == null) return;
        if(size == 1) {
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
    }

    public void removeNode(Node node) {
        if(head == null) return;

        if(node == head) {
            removeFirst();
            return;
        }

        if(node == tail) {
            removeLast();
            return;
        } 
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
        size--;
    }
}

public class LRUCache {
    int capacity, current = 0;
    HashMap<Integer, Node> map;
    DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.dll = new DoublyLinkedList();
    }

    public boolean isCacheFull() {
        return dll.size >= capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        this.dll.removeNode(node);
        map.remove(key);
        put(node.key, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            this.dll.removeNode(node);
            this.dll.addFirst(key, value);
            this.map.put(key, this.dll.head);
        } else {
            if(isCacheFull()) {
                this.map.remove(this.dll.tail.key);
                this.dll.removeLast();
            }
            this.dll.addFirst(key, value);
            this.map.put(key, this.dll.head);
        }
    }
}
