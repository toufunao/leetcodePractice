package design;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap_706 {
    class Node{
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    private static final int size=1000;
    LinkedList[] bucket;
    public MyHashMap_706() {
        bucket=new LinkedList[size];
        for (int i = 0; i < size; i++) {
            bucket[i]=new LinkedList<Node>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash=getHash(key);
        Iterator<Node> iterator=bucket[hash].iterator();
        while (iterator.hasNext()){
            Node node=iterator.next();
            if (node.getKey()==key){
                node.setVal(value);
                return;
            }

        }
        bucket[hash].addLast(new Node(key,value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash=getHash(key);
        Iterator<Node> iterator=bucket[hash].iterator();
        while (iterator.hasNext()){
            Node node=iterator.next();
            if (node.getKey()==key)
                return node.getVal();
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash=getHash(key);
        Iterator<Node> iterator=bucket[hash].iterator();
        while (iterator.hasNext()){
            Node node=iterator.next();
            if (node.getKey()==key){
                bucket[hash].remove(node);
                return;
            }

        }
    }

    private int getHash(int key){
        return  key%size;
    }
}
