package BitWiseOperators;

public class DuplicateElement {
    static int getDuplicate(int[] numbs){
        int ans=-1;
        for(int i=0;i<numbs.length-1;i++){
            ans^=numbs[i];
        }
        for(int i=0;i<numbs.length-1;i++){
            ans^=i;
        }
        return ans;
    }
    static int getDuplicateElementInThree(int[] numbs){
        int ones=0, twos=0;
        for(int num:numbs){
            ones=(ones^num)&(~twos);
            twos=(twos^num)&(~ones);
        }
        return twos;
    }
    public static void main(String[] args){
        int[] numbs1={1,2,3,3,4,5,6,7};
        int[] numbs2={1,1,1,2,2,2,3,3,4,4,4,5,5,5};
        System.out.println("The duplicate Element when all elements are one time :: "+ getDuplicate(numbs1));
        System.out.println("The duplicate Element When all elements are three time:: "+ getDuplicateElementInThree(numbs2));

    }
}
