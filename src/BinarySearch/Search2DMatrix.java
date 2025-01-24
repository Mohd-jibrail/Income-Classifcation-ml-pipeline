package BinarySearch;

public class Search2DMatrix {
    public static int searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int left =0, right = m*n-1;
        while (left<=right){
           int mid = left + (right-left)/2;
           int midValue = matrix[mid/n][mid%n];
           if(midValue==target){
               return mid;
           } else if (midValue < target) {
               left = mid+1;
           } else {
               right= mid+1;
           }
        }
        return -1;
    }
    public static void main(String[] args){
        int[][] numbs ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(searchMatrix(numbs,12));
    }
}
