package BitWiseOperators;

public class TwoUniqueElements {
    static int[] getTwoUniqueElements(int[] numbs){
        int ans=0;
        for(int arr:numbs){
            ans^=arr;
        }
        int setBit= ans&(-ans);
        int num1=0, num2=0;

        for (int arr:numbs){
            if((arr&setBit)==0){
                num1=num1^arr;
            }else {
                num2=num2^arr;
            }
        }
        return new int[]{num1,num2};
    }
    public static void main(String[] args){
        int[] numb={1,1,2,2,3,4,4,5};
        int[] newDep=getTwoUniqueElements(numb);
        System.out.println(newDep[0]+"---"+newDep[1]);
    }
}
