package Array;

import java.util.HashSet;

public class DuplicateElement {

    public static boolean containDuplicate(int[] nums){
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            //check if element is already in the hashSet
            if (seenNumbers.contains(num)) {
                return true;
            }
            seenNumbers.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,6};
        System.out.println(containDuplicate(nums));
    }
}