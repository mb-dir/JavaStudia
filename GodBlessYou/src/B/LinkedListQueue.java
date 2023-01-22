package B;

import java.util.LinkedList;

public class LinkedListQueue {
    private LinkedList<String> queue;
    public LinkedListQueue(){
        queue = new LinkedList<String>();
    }

    public void insert(String el){
        queue.addLast(el);
    }

    public String remove(){
        return queue.remove();
    }

    public String peek(){
        return queue.getFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }
}
