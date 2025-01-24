package BinarySearch;

public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArrays(int[] numbs){
        int left=0;
        int right= numbs.length-1;
        int mid = left + (right-left)/2;
        while (left<right){
            if(numbs[mid]<numbs[mid+1]){
                left = mid+1;
            } else{
                right = mid;
            }
            mid = left +(right-left)/2;
        }
        return left;
    }
    public static void main(String[] args){
        int[] numbs = {7,8,9,10,5,4,3,2,1};
        System.out.println("The Peak element Index :: "+peakIndexInMountainArrays(numbs));
    }
}
