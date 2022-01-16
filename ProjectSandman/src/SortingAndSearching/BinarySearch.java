package SortingAndSearching;
import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int arr[], int low, int high, int value){
        if(high >= low){
            int mid = low + (high - low) /2;

            if(arr[mid] == value){
                return mid;
            }

            if(arr[mid] > value){
                return binarySearch(arr, low, mid -1, value);
            }
            else return binarySearch(arr, mid +1 , high, value);
        }

        return -1;
    }

    public static int findOffset(int arr[], int low, int high){
        if(low <= high){
            int mid = low + (high -low) /2;
            if(mid == 0 || arr[mid] < arr[mid-1]){
                return mid;
            }
            if(arr[mid] > arr[0]){
                return findOffset(arr, mid +1, high);
            }else{
                return findOffset(arr, low, mid -1);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int arr[] = {0,2};

        Arrays.sort(arr);

        System.out.println(binarySearch(arr,0, arr.length-1, 2));
    }
}
