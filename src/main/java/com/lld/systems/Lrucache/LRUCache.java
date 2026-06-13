package com.lld.systems.Lrucache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {

        //Users Data
        User u1 = new User(1, "Sushil");
        User u2 = new User(2, "Divyani");
        User u3 = new User(3, "Varun");
        User u4 = new User(4, "Akash");
        User u5 = new User(5, "Yash");

        Cache cache = new Cache(3);
        cache.put(u1.getId(), u1);
        cache.put(u2.getId(), u2);
        cache.put(u3.getId(), u3);

        cache.put(1,u1);
        cache.put(2,u2);
        cache.put(3,u3);

        cache.get(2);

        cache.put(4,u4);

        cache.printCache();
    }
}

class Cache {
    private final Map<Object, Node> cacheMap;
    private final Node head;
    private final Node tail;
    private final int size;

    Cache(int size) {
        this.size = size;
        cacheMap = new HashMap<>(size);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    //GET
    public Object get(Object key) {
        if (!cacheMap.containsKey(key)) {
            //fetch the data from db and save in map;
            System.out.println("Cache does not contain value, fetching from db");
            return null;
        } else {
            Node node = cacheMap.get(key);
            deleteNode(node);
            insert(node);
            return node.data;
        }
    }

    //DELETE
    public void delete(Object key) {
        Node node = cacheMap.get(key);
        cacheMap.remove(key);
        deleteNode(node);

    }

    //PUT
    public String put(Object key, Object value) {
        if(cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.data = value;
            deleteNode(node);
            insert(node);
            return "Already present. Updated successfully!";
        }

        if (cacheMap.size() == size) {
            Node tempNode = tail.prev;
            deleteNode(tempNode);
            cacheMap.remove(tempNode.key);
        }
        Node node = new Node(key,value);
        insert(node);
        cacheMap.put(key,node);
        return "Insertion done successfully";
    }

    private void insert(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void deleteNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void printCache() {
        for(Map.Entry<Object,Node> entry: cacheMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().data);
        }
    }
}


class Node {
    Object key;
    Object data;
    Node next;
    Node prev;

    Node(Object key, Object data) {
        this.key = key;
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

@Getter
@Setter
@ToString
@AllArgsConstructor
class User {
    int id;
    String name;
}


