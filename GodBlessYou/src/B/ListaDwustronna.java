package B;

import java.util.LinkedList;

public class ListaDwustronna {
    private LinkedList<String> lista;

    public ListaDwustronna(){
        lista = new LinkedList<String>();
    }

    public void insertFirst(String el){
        lista.addFirst(el);
    }

    public void insertLast(String el){
        lista.addLast(el);
    }

    public String getFirst(){
        return lista.getFirst();
    }

    public String getLast(){
        return lista.getLast();
    }

    public String removeFirst(){
        return lista.removeFirst();
    }

    public String removeLast(){
        return lista.removeLast();
    }

    public boolean isEmpty(){
        return lista.isEmpty();
    }

    public int size(){
        return lista.size();
    }

}
