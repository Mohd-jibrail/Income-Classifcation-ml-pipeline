package Array;

public class MinMaxArray {
    static int getMax(int[] numbs){
        int max=-122334;
        for(int n:numbs){
            if(n>max){
                max=n;
            }
        }
        return max;
    }
    static int getMin(int[] numbs){
        int min=1234334;
        for(int n:numbs){
            if(min>n){
                min=n;
            }
        }
        return min;
    }
    public static void main(String[] args){
        int[] numb={1,12,3,4,5,6,7};
        System.out.println("Max :: "+getMax(numb));
        System.out.println("Min :: "+getMin(numb));
    }
}
