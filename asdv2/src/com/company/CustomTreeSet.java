package com.company;

import java.util.Iterator;
import java.util.TreeSet;

public class CustomTreeSet {
    private TreeSet<String> TS;

    public CustomTreeSet(){
        TS = new TreeSet<String>();
    }

    public TreeSet<String> getTS() {
        return TS;
    }

    public boolean isMember(String el){
        return TS.contains(el);
    }

    public int size(){
        return TS.size();
    }

    public void insert(String el){
        if(!isMember(el)){
            TS.add(el);
        }
    }

    public boolean delete(String el){
        if(isMember(el)){
            TS.remove(new String(el));
            return true;
        }else{return false;}

    }

    public CustomTreeSet union(CustomTreeSet nd){
        Iterator<String> iterator = TS.iterator();
        Iterator<String> iterator2 = nd.getTS().iterator();

        CustomTreeSet unionSet = new CustomTreeSet();

        while (iterator.hasNext()){
            unionSet.insert(iterator.next());
        }

        while (iterator2.hasNext()){
            unionSet.insert(iterator2.next());
        }

        return unionSet;
    }

    public CustomTreeSet insertion(CustomTreeSet nd){
        CustomTreeSet insertionSet = new CustomTreeSet();

        Iterator<String> iterator = TS.iterator();

        while(iterator.hasNext()){
            String elem = iterator.next();
            if(nd.isMember(elem)){
                insertionSet.insert(elem);
            }
        }
        return insertionSet;
    }

    public CustomTreeSet difference(CustomTreeSet nd){
        CustomTreeSet differenceSet = new CustomTreeSet();

        Iterator<String> iterator = TS.iterator();

        while(iterator.hasNext()){
            String elem = iterator.next();
            if(!nd.isMember(elem)){
                differenceSet.insert(elem);
            }
        }
        return differenceSet;
    }

    public void print(){
        for (String el: TS) {
            System.out.println(el);
        }
    }
}
