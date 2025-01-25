package BitWiseOperators;

public class UniqueElement {
    static int uniqueElement(int[] numbs){
        int uniqueEl = 0;
        for(int i=0;i<=numbs.length-1;i++){
            uniqueEl^=numbs[i];
        }
        return uniqueEl;
    }
    static int uniqueElementInThree(int[] numbs){
        int ones=0, twos=0;
        for(int num:numbs){
            ones=(ones^num)&(~twos);
            twos=(twos^num)&(~ones);
        }
        return twos;
    }
    public static void main(String[] args){
        int[] numbs1={1,1,2,2,3,4,4,5,5,6,6,7,7,8,8,9,9};
        int[] numbs2={1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,8,8,7,7,7};
        System.out.println("The Unique Element :: "+uniqueElement(numbs1));
        System.out.println("The Unique Element :: "+uniqueElementInThree(numbs2));
    }
}
