package BitWiseOperators;
import java.util.ArrayList;
import java.util.List;

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
    public static int findPosition(int n) {
        if (n <= 0 || (n & (n - 1)) != 0) {
            return -1; // Invalid input
        }
        int position = 1;
        while ((n & 1) == 0) {
            n >>= 1;
            position++;
        }
        return position;
    }
    public static int copySetBits(int x, int y, int l, int r) {
        int maskLength = (1 << (r - l + 1)) - 1;
        int mask = (maskLength << (l - 1)) & y;
        return x | mask;
    }
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return sign * quotient;
    }
    public static int square(int n) {
        if (n == 0) return 0;
        if (n < 0) n = -n;

        int x = n >> 1;
        if (n % 2 != 0) {
            return (square(x) << 2) + (x << 2) + 1;
        } else {
            return square(x) << 2;
        }
    }
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }

        return result;
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
        //Q6
        System.out.println(n + " is power of two: " + isPowerOfTwo(n));
        //Q6
        int n1= 16; // Example number
        System.out.println("Position of the only set bit: " + findPosition(n1));
        //Q7
        int x = 10, y = 13, l = 2, r = 3; // Example values
        System.out.println("Result after copying set bits: " + copySetBits(x, y, l, r));
        //Q8
        int dividend = 10, divisor = 3; // Example values
        System.out.println("Result of division: " + divide(dividend, divisor));
        //Q9
        System.out.println("Square of " + n + " is: " + square(n));
        //Q10
        int[] numbs = {1, 2, 3}; // Example array
        List<List<Integer>> subsets = powerSet(numbs);
        System.out.println("Power set: " + subsets);
    }
}
