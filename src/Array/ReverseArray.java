package Array;

public class ReverseArray {
    static int[] getReverseArray(int[] numb){
        int left=0, right=numb.length-1;
        while (left<=right){
            numb[left]=numb[left]^numb[right];
            numb[right]=numb[left]^numb[right];
            numb[left]=numb[right]^numb[left];
            left++;
            right--;
        }
        return numb;
    }
    public static void main(String[] args){
        int[] numb={1,2,3,4,5,6,7,8};
        int[] newNumb=getReverseArray(numb);
        for(int n:newNumb){
            System.out.print(n+"-");
        }
        System.out.println("NULL");
    }
}
