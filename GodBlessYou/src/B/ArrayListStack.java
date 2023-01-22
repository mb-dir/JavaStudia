package B;

import java.util.ArrayList;

public class ArrayListStack {
    private ArrayList<String> stack;

    public ArrayListStack(){
        stack = new ArrayList<String>();
    }

    public void push(String elem){
        stack.add(elem);
    }

    public String peek(){
        return stack.get(stack.size()-1);
    }
    public String pop(){
        return stack.remove(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
