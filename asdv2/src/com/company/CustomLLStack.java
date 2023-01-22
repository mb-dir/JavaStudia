package com.company;

import java.util.LinkedList;

public class CustomLLStack {
    private LinkedList<Double> myLL;

    public CustomLLStack(){
        myLL = new LinkedList<Double>();
    }

    public void push(Double e){
        myLL.push(e);
    }

    public Double pop(){
        return myLL.pop();
    }

    public Double peek(){
        return myLL.peek();
    }

    public boolean isEmpty(){
        return myLL.isEmpty();
    }
}
