package Arrays;

public class RotateArray {

    public static void rotateArray(int arr[], int start, int end){
        while(start < end){
             arr[start] = arr[start] ^ arr[end];
             arr[end] =   arr[start] ^ arr[end];
             arr[start] = arr[start] ^ arr[end];
             start++;
             end--;
        }
    }

    public static void main(String[] args) {
        int k = 2;
        int arr[] = {1, 2, 3, 4, 5, 6};
        rotateArray(arr, 0, arr.length - 1);
        rotateArray(arr, 0, k);
        rotateArray(arr, k + 1, arr.length-1);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }
}
