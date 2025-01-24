package SortingAlgos;

public class SelectionSort {
    static int[] selection(int[] numb){

        for (int i=0; i<numb.length-1; i++){
            for (int j=i; j<numb.length-1; j++){
                if(numb[i]>numb[j]){
                    int temp= numb[i];
                    numb[i]=numb[j];
                    numb[j]=temp;
                }
            }
        }
        return numb;
    }
    public static void main(String[] args){
        int[] numb1={1,22,4,9,26};
        int[] numb2=selection(numb1);
        for(int i=0; i<numb2.length-1;i++){
            System.out.println(numb2[i]);
        }
    }
}
