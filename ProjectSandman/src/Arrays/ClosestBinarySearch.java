package Arrays;
import java.util.Arrays;

public class ClosestBinarySearch {

    public static int closestBinarySearch(int inputArray[], int low, int high, int key, int minDiff, int nearest){

        if(low <= high){
            int mid = (low + high)/2;
            if(inputArray[mid] == key){
                return mid;
            }
            int currentDiff = Math.abs(Math.abs(inputArray[mid]) - Math.abs(key));
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

    public static void main(String[] args) {
        int arr[] = {-1, 5, 10, 20, 28, 3};
        // -1, 3, 5, 10, 20, 28
        Arrays.sort(arr);
        System.out.println(closestBinarySearch(arr, 0, arr.length - 1, 3, Integer.MAX_VALUE, 0));
    }
}
