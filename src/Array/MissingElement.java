package Array;

public class MissingElement {
    static int missingElement1(int[] numbs){
        for(int i=0;i<numbs.length-1;i++){
            if(numbs[i]+1!=numbs[i+1]){
                return numbs[i]+1;
            }
        }
        return -1;
    }
    static int missingElement2(int[] numbs){
        int ans=0;
        for(int i=0;i<numbs.length-1;i++){
            ans=ans^numbs[i];
        }
        for(int i=1;i<numbs.length+1;i++){
            ans=ans^i;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] numbs={1,2,3,4,5,6,8};
        System.out.println("Missing :: "+missingElement1(numbs));
        System.out.println("Missing :: "+missingElement2(numbs));
    }
}
