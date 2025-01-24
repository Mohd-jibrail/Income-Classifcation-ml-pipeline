package SortingAlgos;

public class BubbleSort {
    static int[] bubbleSort(int[] numbs){
        //System.out.println(numbs.length-1);
        int n=numbs.length-1;
        for (int i=0; i<n; i++){
            for (int j=0; j<n-1;j++){
                if(numbs[j]>numbs[j+1]){
                    int temp = numbs[j];
                    numbs[j]=numbs[j+1];
                    numbs[j+1]=temp;
                }
            }
        }
        return numbs;
    }
    public static void main(String[] args){
        int[] num1={8,4,7,1,5,2};
        int[] num2= bubbleSort(num1);
        for (int i=0; i<num2.length-1; i++){
            System.out.print(num2[i]+",");
        }
    }
}
