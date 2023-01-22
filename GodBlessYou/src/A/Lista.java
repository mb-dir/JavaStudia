package A;

public class Lista {
    ListElem first;

    public Lista(){
        first = null;
    }

    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        return false;
    }

    public void insert(int el){
        ListElem current = first;
        ListElem prev = null;
        ListElem nowy = new ListElem(el);

        while(current!=null && nowy.value > current.value){
            prev = current;
            current = current.next;
        }

        if(prev == null){
            first = nowy;
        }else{
            prev.next = nowy;
        }
        nowy.next=current;
    }

    public ListElem delete(int value){
        if(isEmpty()) return null;
        ListElem current = first;
        ListElem prev = null;

        while(current.value != value){
            if(current.next == null) return null;
            prev = current;
            current = current.next;
        }

        if(prev == null){
            first=first.next;
        }else{
            prev.next = current.next;
        }
        return current;
    }

    public ListElem find(int value){
        ListElem current = first;
        while(current.value!=value){
            if (current.next==null)return null;
            current=current.next;
        }
        return current;
    }

    public void print(){
        ListElem current = first;
        while(current != null){
            System.out.println(current.value);
            current=current.next;
        }
    }
}
