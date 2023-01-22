package B;

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
            return TS.remove(el);
        }
        return false;
    }

    public CustomTreeSet union(CustomTreeSet nd){
        Iterator<String> itereator = TS.iterator();
        Iterator<String> iterator2 = nd.getTS().iterator();

        CustomTreeSet unionSet = new CustomTreeSet();

        while(itereator.hasNext()){
            String el = itereator.next();
            unionSet.insert(el);
        }

        while(iterator2.hasNext()){
            String el = iterator2.next();
            unionSet.insert(el);
        }

        return unionSet;
    }

    public CustomTreeSet insertion(CustomTreeSet nd){
        Iterator<String> itereator = TS.iterator();
        CustomTreeSet insertionSet = new CustomTreeSet();
        while(itereator.hasNext()){
            String el = itereator.next();
            if(nd.isMember(el)){
                insertionSet.insert(el);
            }
        }

        return insertionSet;
    }

    public CustomTreeSet difference(CustomTreeSet nd){
        Iterator<String> itereator = TS.iterator();
        CustomTreeSet differenceSet = new CustomTreeSet();
        while(itereator.hasNext()){
            String el = itereator.next();
            if(!nd.isMember(el)){
                differenceSet.insert(el);
            }
        }

        return differenceSet;
    }

    public void print(){
        Iterator<String> iterator = TS.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println();
    }
}
