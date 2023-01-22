package C;

public class Main {
    static int[] tablica ={12,21,4,5,2,5,7,89,56,3,4,4,356,234};
    public static void main(String[] args) {
        System.out.println("Przed");
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
        }

        mergeSort(0, tablica.length-1);

        System.out.println();
        System.out.println("Po");

        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
        }
    }

    public static void merge(int l, int m, int r){
        int [] tempArr = new int[r-l+1];
        int i = l;
        int j = m+1;
        int k=0;

        while((i<=m) || (j<=r)){
            if(i==m+1){
                tempArr[k] = tablica[j];
                j++;
                k++;
            }else if(j==r+1){
                tempArr[k] = tablica[i];
                i++;
                k++;
            }else{
                if(tablica[i] < tablica[j]){
                    tempArr[k] = tablica[i];
                    i++;
                    k++;
                }else{
                    tempArr[k] = tablica[j];
                    j++;
                    k++;
                }
            }
        }

        int d = l;
        for (int n = 0; n < tempArr.length; n++) {
            tablica[d] = tempArr[n];
            d++;
        }
    }

    public static void mergeSort(int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(l,m);
            mergeSort(m+1,r);
            merge(l,m,r);
        }
    }
}
