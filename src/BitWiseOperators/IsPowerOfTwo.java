package BitWiseOperators;

public class IsPowerOfTwo {
    static boolean isPowerOfTwo(int num){

        return (num & (num - 1)) == 0;
    }
    public static void main(String[] args){
        int num=61;
        if (isPowerOfTwo(num)) {
            System.out.println("Yes, "+num +" is a power of 2 ::");
        }else {
            System.out.println("No, "+num +" is not a power of 2 ::");
        }
    }
}
