package BitWiseOperators;

import java.util.Vector;

public class SwappingNumbers {
    static int[] swap(int[] numbs){
        numbs[0]=numbs[0]^numbs[1];
        numbs[1]=numbs[0]^numbs[1];
        numbs[0]=numbs[0]^numbs[1];
        return new int[]{numbs[0],numbs[1]};
    }
    public static void main(String[] args){
        int[] oldValues ={12,123};
        int[] newValues=swap(oldValues);
        System.out.println("New values of a :: "+newValues[0]+" New values of b :: "+newValues[1]);
    }
}
