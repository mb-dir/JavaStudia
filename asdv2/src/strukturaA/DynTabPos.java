package strukturaA;

public class DynTabPos {
    private String[] tabDyn;
    private int ileElementow;

    public DynTabPos(int max){
        tabDyn = new String[max];
        ileElementow=0;
    }

    public void add(String elem){
        if(ileElementow>=tabDyn.length){
            //relokacja
            String[] tempTab = new String[tabDyn.length*2];
            for(int i = 0; i < tabDyn.length; i++){
                tempTab[i]=tabDyn[i];
            }
            tabDyn=tempTab;
        }

        //znajdź index gdzie ma być wrzucony element
        int j;
        for (j = 0; j < ileElementow; j++){

            if(tabDyn[j].compareTo(elem) > 0){
                break;
            }
        }

        for(int i = ileElementow; i > j; i--){
            tabDyn[i]=tabDyn[i-1];
        }

        tabDyn[j]=elem;

        ileElementow++;
    }

    public String get(int index){
        return tabDyn[index];
    }

    public boolean remove(int index){
        if(index < 0 || index >= ileElementow || ileElementow ==0){
            return false;
        }
        for(int i = index; i < ileElementow-1; i++){
            tabDyn[i]=tabDyn[i+1];
        }
        ileElementow--;
        return true;
    }

    public void print(){
        for (int i = 0; i < ileElementow; i++) {
            System.out.println(tabDyn[i]);
        }
    }
}
