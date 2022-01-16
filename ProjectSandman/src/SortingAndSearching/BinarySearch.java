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


    public static void main(String[] args) {
        int arr[] = {2,4,5,2,4,3,10,7,8};

        Arrays.sort(arr);

        System.out.println(binarySearch(arr,0, arr.length-1, 10));

        System.out.println(arr[8]);
    }
}
