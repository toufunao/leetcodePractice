package special;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    class DoubleLinkedListNode{
        int key;
        int value;
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;

        public DoubleLinkedListNode() {
        }

        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer,DoubleLinkedListNode> cache=new HashMap<>();
    int size;
    int capacity;
    DoubleLinkedListNode head,tail;

    public LRUCache_146(int capacity) {
        this.capacity=capacity;
        this.size=0;
        head=new DoubleLinkedListNode();
        tail=new DoubleLinkedListNode();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        DoubleLinkedListNode node=cache.get(key);
        if (node==null)
            return -1;

        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedListNode node=cache.get(key);
        if (null==node){
            DoubleLinkedListNode newNode=new DoubleLinkedListNode(key,value);
            cache.put(key,newNode);
            add2Head(newNode);
            size++;
            if (size>capacity){
                DoubleLinkedListNode remove=removeTail();
                cache.remove(remove.key);
                size--;
            }
        }else {
            node.value=value;
            move2Head(node);
        }

    }

    void deleteNode(DoubleLinkedListNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void move2Head(DoubleLinkedListNode node) {
        deleteNode(node);
        add2Head(node);
    }

    private DoubleLinkedListNode removeTail() {
        DoubleLinkedListNode temp=tail.pre;
        deleteNode(temp);
        return temp;
    }

    private void add2Head(DoubleLinkedListNode node) {
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;

    }


}
