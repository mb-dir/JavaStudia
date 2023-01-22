package com.company;

import java.util.LinkedList;

public class CustomLLQueue {
    private LinkedList<String> myQQ;

    public CustomLLQueue(){
        myQQ = new LinkedList<String>();
    }

    public void insert(String elem){
        myQQ.add(elem);
    }

    public String remove(){
        return myQQ.remove();
    }

    public String peek(){
        return myQQ.peek();
    }

    public boolean isEmpty(){
        return myQQ.isEmpty();
    }

    public int size(){
        return myQQ.size();
    }
}
