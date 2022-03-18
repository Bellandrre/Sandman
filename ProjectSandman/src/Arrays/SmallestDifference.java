package Arrays;
import java.util.Arrays;

public class SmallestDifference {
    public static int closestBinarySearch(int inputArray[], int low, int high, int key, int minDiff, int nearest){

        if(low <= high){
            int mid = (low + high)/2;
            if(inputArray[mid] == key){
                return mid;
            }
            int currentDiff = Math.abs(inputArray[mid] - key);
            if(currentDiff < minDiff){
                nearest = mid;
                minDiff = currentDiff;
            }
            if(inputArray[mid] < key){
                return closestBinarySearch(inputArray, mid + 1, high, key, minDiff, nearest);
            }else{
                return closestBinarySearch(inputArray, low, mid - 1, key, minDiff, nearest);
            }
        }
        return nearest;
    }


    public static int[] smallestDifference(int[] arr1, int[] arr2) {

        int biggerArray[] = arr1.length > arr2.length ? arr1 : arr2;
        int smallerArray[] = arr1.length > arr2.length ? arr2 : arr1;
        // Write your code here.
        Arrays.sort(biggerArray);
        Arrays.sort(smallerArray);
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        for(int i = 0; i < biggerArray.length; i++){
            int currElement = biggerArray[i];
            int nearest = smallerArray[closestBinarySearch(smallerArray, 0, smallerArray.length - 1, currElement, Integer.MAX_VALUE, 0)];
            int currDiff = Math.abs(currElement - nearest);
            if(currDiff < minDiff){
                result[0] = currElement;
                result[1] = nearest;
                minDiff = currDiff;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int arr1[] = {-1, 5, 10, 20, 28, 3};
        int arr2[] = {26, 134, 135, 15, 17};
        int [] result = smallestDifference(arr1, arr2);
        System.out.println(result[0] + " "+ result[1]);
    }
}
