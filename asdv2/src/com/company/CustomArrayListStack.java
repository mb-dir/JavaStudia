package com.company;

import java.util.ArrayList;

public class CustomArrayListStack {
    private ArrayList<Double> stack;

    public CustomArrayListStack(){
        stack = new ArrayList<Double>();
    }
    public void push(Double element){
        stack.add(element);
    }
    public Double pop(){
        return stack.remove(stack.size()-1);
    }
    public Double peek(){
        return stack.get(stack.size()-1);
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
