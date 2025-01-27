package BitWiseOperators;

public class TenBitwiseImportantProblems {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public static void findNonRepeating(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        int setBit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        System.out.println("The two non-repeating elements are: " + x + " and " + y);
    }
    public static int countBitsToFlip(int a, int b) {
        int xor = a ^ b;
        int count = 0;
        while (xor > 0) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }
    public static int countTotalSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += Integer.bitCount(i);
        }
        return count;
    }
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
    public static void main(String[] args) {
        //Q1
        int n = 8; // Example number
        System.out.println("Number of set bits: " + countSetBits(n));
        //Q2
        int[] arr = {2, 4, 7, 9, 2, 4, 9, 11}; // Example array
        findNonRepeating(arr);
        //Q3
        int a = 9, b = 8; // Example numbers
        System.out.println("Number of bits to be flipped: " + countBitsToFlip(a, b));
        //Q4
        int m = 5; // Example number
        System.out.println("Total set bits from 1 to " + m + ": " + countTotalSetBits(m));
        System.out.println(n + " is power of two: " + isPowerOfTwo(n));
    }
}
