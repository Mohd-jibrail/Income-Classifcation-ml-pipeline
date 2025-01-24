package BinarySearch;

public class BinarySearch {
    public static int search(int[] numbs, int target){
        int left=0, right=numbs.length-1;
        int mid;
        while (left<=right){
            mid = left + (right-left)/2;
            if(numbs[mid]== target){
                return mid;
            }else if (numbs[mid]<target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] numbs ={1,2,3,4,5,6,7,8};
        int target =7;
        System.out.println(search(numbs,target));
    }
}
