package Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum {
    /**
     * Time complexity  - O(N)^2
     * [12, 3, 1, 2, -6, 5, -8, 6]
     * @param array
     * @param target
     * @return
     */
    public static List<Integer[]> threeNumberSum(int[] array, int target) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();

        for(int i= 0; i <= array.length - 3; i++){
            int j = i + 1;
            int k = array.length - 1;
            while(j != k){
                int currSum = array[i] + array[j] + array[k];
                if(currSum == target){
                    Integer[] currResult = new Integer[3];
                    currResult[0] = array[i];
                    currResult[1] = array[j];
                    currResult[2] = array[k];
                    result.add(currResult);
                }
                if(currSum < target ){
                    int currElement = array[j];
                    j++;

                }else{
                    int currElement = array[k];
                    k--;
                }
            }

        }
        return result;
    }
}
