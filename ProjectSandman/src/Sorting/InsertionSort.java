package Sorting;
/*
The insertion sort is efficient for small number of elements
The best case of insertion sort is = O(n)
The work case of insertion sort is = O(n^2)
 */
public class InsertionSort {

    static int arr[] = {5,2,4,6,1,3};


    /**
     * The insertion sort in increasing order
     * @param arr
     */
    public static void insertionSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int currElement = arr[i];
            int j = i -1;
            while(j >= 0 && arr[j] > currElement){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = currElement;
        }
    }

    /**
     * The insertion sort in non increasing order
     * @param arr
     */
    public static void insertionSortDecresingOrder(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int currElement = arr[i];

            int j = i -1;
            while(j >=0 && arr[j] < currElement){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currElement;
        }
    }

    public static void main(String[] args) {
        insertionSort(arr);
        insertionSortDecresingOrder(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }
}
