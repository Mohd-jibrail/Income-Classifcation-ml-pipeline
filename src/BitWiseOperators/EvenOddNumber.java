package BitWiseOperators;

public class EvenOddNumber {
    static boolean isEvenNumber(int num){
        if((num&1)==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        int num=12;
        if(isEvenNumber(num)){
            System.out.println("The number is Even");
        }else {
            System.out.println("The number is Odd");
        }
    }
}
