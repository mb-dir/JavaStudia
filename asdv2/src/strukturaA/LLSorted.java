package strukturaA;

import java.util.List;

public class LLSorted {
    private ListElem first;

    public LLSorted(){
        first = null;
    }

    public boolean isEmpty(){
        if(first == null) return true;
        return false;
    }

    public void insertFirst(int value){
        ListElem elem = new ListElem(value);
        elem.next = first;
        first = elem;
    }

    public void insert(int value){
        ListElem elem = new ListElem(value);
        ListElem prev = null;
        ListElem current = first;
        while(current != null && elem.value > current.value){
            prev = current;
            current = current.next;
        }
        //wyjebka pierwszego elementu
        if(prev == null){
            first = elem;
        }else{
            prev.next = elem;
            elem.next = current;
        }
    }

    public ListElem find(int value){
        if(isEmpty()){
            return null;
        }
        ListElem current = first;
        if(current.next == null){
            return null;
        }
        while(current.value != value){
            if(current.next == null) return null;
            current = current.next;
        }
        return current;
    }

    public ListElem deleteFirst(){
        if(isEmpty()){
            return null;
        }
        ListElem temp = first;
        first = first.next;
        return temp;
    }

    public ListElem delete(int value){
        if(isEmpty()){
            return null;
        }

        ListElem prev = null;
        ListElem current = first;

        while(current.value != value){
            if(current.next == null) return null;
            else{
                prev=current;
                current=current.next;
            }
        }

        //wyjebka pierwszego elementu
        if(prev == null){
            first = first.next;
        }
        prev.next = current.next;
        return current;
    }

    public void print(){//początek ->koniec
        ListElem current = first;
        while(current.next!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
