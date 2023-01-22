package A;

public class TablicaDynamicznaPosortowana {
    private String[] tablica;
    private int ileElementow;
    public TablicaDynamicznaPosortowana(int max){
        ileElementow = 0;
        tablica = new String[max];
    }

    public void add(String el){
        if(ileElementow >=tablica.length){
            String[] relokacyjna = new String[tablica.length*2];
            for(int i = 0; i < tablica.length; i++){
                relokacyjna[i] = tablica[i];
            }
            tablica = relokacyjna;
        }

        int j;
        //index szukany jest
        for(j=0; j<ileElementow; j++){
            if(tablica[j].compareTo(el) > 0){
                break;
            }
        }

        //przesuwamy elementy tablicy
        for(int i = ileElementow; i > j; i--){
            tablica[i]=tablica[i-1];
        }
        tablica[j]=el;
        ileElementow++;
    }

    public boolean remove(int index){
        if(index < 0 || index >= ileElementow || ileElementow==0) return false;
        for(int i = index; i < ileElementow-1; i++){
            tablica[i] = tablica[i+1];
        }
        ileElementow--;
        return true;
    }

    public String get(int index){
        if(index < 0 || index >= ileElementow || ileElementow==0) return null;
        return tablica[index];
    }

    public int find(String el){
        for(int i = 0; i < ileElementow; i++){
            if(tablica[i].equals(el)) return i;
        }
        return -1;
    }

    public int size(){
        return tablica.length;
    }

    public void print(){
        for(int i = 0; i < ileElementow; i++){
            System.out.print(tablica[i] + " ");
        }
    }
}
