package com.company;

import java.util.LinkedList;

public class ListaDwustronna {
    private LinkedList<String> LD;

    public boolean isEmpty(){
        return LD.isEmpty();
    }

    public ListaDwustronna(){
        LD = new LinkedList<String>();
    }

    public void insertFirst(String el){
        LD.addFirst(el);
    }

    public void insertLast(String el){
        LD.addLast(el);
    }

    public void deleteFirst(){
        LD.removeFirst();
    }

    public void deleteLast(){
        LD.removeLast();
    }

    public String getFirst(){
        return LD.getFirst();
    }

    public String getLast(){
        return LD.getLast();
    }

    public int size(){
        return LD.size();
    }

    public void print(){
        while(!LD.isEmpty()){
            System.out.println(LD.removeFirst());
        }
    }
}
