package com.company;

import java.util.ArrayList;

public class CustomALQueue {
    private ArrayList<String> myQQ;

    public CustomALQueue(){
        myQQ = new ArrayList<String>();
    }

    public void insert(String e){
        myQQ.add(e);
    }

    public String remove(){
       return myQQ.remove(0);
    }

    public String peek(){
        return myQQ.get(0);
    }

    public int size(){
        return myQQ.size();
    }

    public boolean isEmpty(){
        return myQQ.isEmpty();
    }
}
