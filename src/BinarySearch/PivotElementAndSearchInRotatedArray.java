package BinarySearch;

public class PivotElementAndSearchInRotatedArray {
    public static int getPivot(int[] numbs){
        int left = 0;
        int right = numbs.length-1;
        int mid = left + (right-left)/2;
        while (left<right){
            if(numbs[mid]>numbs[0]){
                left = mid+1;
            } else{
                right = mid;
            }
            mid = left + (right-left)/2;
        }
        return left;
    }
    public static int binarySearch(int[] numbs, int left, int right, int key){
        int mid = left + (right+left)/2;
        while (left<right){
            if(numbs[mid]==key){
                return mid;
            } else if (numbs[mid]<key) {
                left = mid+1;
            } else if(numbs[mid]>key){
                right =  mid-1;
            }
            mid = left + (right-left)/2;
        }
        return -1;
    }
    public static int rotatedArraySearch(int[] numbs, int key) {
        int pivot = getPivot(numbs);
        if (numbs[pivot] == key) {
            return pivot;
        } else if (key >= numbs[pivot] && key <= numbs[numbs.length - 2]) {
            return binarySearch(numbs, pivot-1, numbs.length - 2, key);
        } else {
                return binarySearch(numbs,0,pivot,key);
        }
    }
    public static void main(String[] args){
        int[] numbs ={7,8,9,10,1,2,3,4,5,6};
        System.out.println("Pivot Index :: "+getPivot(numbs));
        System.out.println("Search element :: "+rotatedArraySearch(numbs,10));
    }
}
