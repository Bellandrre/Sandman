import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class ThreeSum {
//         [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]

    public static List<List<Integer>> threeSum(int array[]){
        Arrays.sort(array); // [-4, -1, -1, 0, 1, 2]  [[-1, -1, 2][-1, 0, 1]]
        //                               ^
        //                                   ^ ^
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        for(int i = 0 ; i <= array.length -3 ; i++) {
            int sum = array[i];
            int requiredSum = target - sum;
            int startPtr = i + 1;
            int endPtr = array.length - 1;
            if (i == 0 || array[i] > array[i - 1]) {
                while (startPtr != endPtr) {

                    int currSum = array[startPtr] + array[endPtr] + array[i];
                    if (currSum == target) {
                        List currResult = new ArrayList();
                        currResult.add(array[i]);
                        currResult.add(array[startPtr]);
                        currResult.add(array[endPtr]);
                        result.add(currResult);
                    }

                    if (array[startPtr] + array[endPtr] < requiredSum) {
                        int currStart = array[startPtr];
                        while (array[startPtr] == currStart && startPtr < endPtr) {
                            startPtr++;
                        }

                    } else {
                        int currEnd = array[endPtr];
                        while (array[endPtr] == currEnd && endPtr > startPtr) {
                            endPtr--;
                        }

                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int array[] = {0, 0, 0};
        System.out.println(threeSum(array).toString());
    }
}
