package strukturaA;

public class ListElem {
    int value;
    ListElem next;

    public ListElem(int value){
        this.value = value;
        next = null;
    }

    public String toString(){
        return Integer.toString(value);
    }
}
