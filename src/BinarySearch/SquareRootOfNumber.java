package BinarySearch;

public class SquareRootOfNumber {
    public static int squareTootBinaryNumber(int n){
        int left = 0;
        int right = n;
        int mid = left + (right -left)/2;
        int ans = -1;
        while (left<=right){
            int square = mid*mid;
            if(square==n){
                return mid;
           }
            if(square<n){
                ans = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
            mid = left+(right-left)/2;
        }
        return ans;
    }
    private static double morePreciseSquareTootBinaryNumber(int n, int precision, int tempSol){
        double factor =1;
        double ans = tempSol;
        for(int i=0; i<precision; i++){
            factor = factor/10;
            for(double j=ans; j*j<n;j=j+factor){
                ans=j;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int n=68;
        System.out.println("Square Root :: " +morePreciseSquareTootBinaryNumber(68,2,squareTootBinaryNumber(68)));
    }
}
