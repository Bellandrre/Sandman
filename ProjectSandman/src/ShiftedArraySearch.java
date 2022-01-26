import java.util.Arrays;

public class ShiftedArraySearch {


    public static int findPivot(int arr[], int low, int high){
        if(low <= high){
            int mid = (low + high)/2;
            if(mid == 0 || arr[mid] < arr[mid -1]){
                return mid;
            }
            if(arr[mid] < arr[0]){
                return findPivot(arr, low, mid -1);
            }else{
                return findPivot(arr, mid + 1, high);
            }
        }
        return -1;
    }


    public static int binarySearchIterative(int arr[], int low, int high, int key){
        while(low <= high){
            int mid = (low + high) /2 ;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] > key){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int low, int high, int key){
        if(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] > key){
                 return binarySearch(arr, low, mid -1, key);
            }else if (arr[mid] == key){
                return mid;
            }else{
                return binarySearch(arr, mid + 1, high, key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {9, 12, 17, 2, 4, 5};

        int pivot = findPivot(arr, 0, arr.length -1);

        System.out.println(pivot);
    }

}
