package BinarySearch;

public class FirstAndLastOccurrence {

    public static int firstOccurrence(int[] numbs, int key){
        int left=0;
        int right= numbs.length-1;
        int ans=-1;
        int mid=0;

        while (left<=right){
            mid = left+(right-left)/2;
            if(numbs[mid]==key){
                ans = mid;
                right= mid-1;
            } else if (numbs[mid]<key) {
                left= mid+1;
            } else {
                right = mid-1;
            }
        }
    return ans;
    }
    public static int lastOccurrence(int[] numbs, int key){
        int left=0;
        int right = numbs.length-1;
        int ans=-1;
        int mid=0;
        while (left<=right){
            mid = left+(right-left)/2;
            if(numbs[mid]==key){
                ans= mid;
                left=mid+1;
            }else if (numbs[mid]<key) {
                left = mid+1;
            } else {
                right = mid-1;
            }

        }
        return ans;
    }
    public static void main(String[] args){
        int[] numbs={1,2,3,4,4,5,5,5,6};
        System.out.println("First OCC "+firstOccurrence(numbs,9));
        System.out.println("Last Occ "+ lastOccurrence(numbs,9));
    }
}
