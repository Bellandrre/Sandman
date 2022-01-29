package Sorting;
/*
The insertion sort is efficient for small number of elements
The best case of insertion sort is = O(n)
The work case of insertion sort is = O(n^2)
 */
public class InsertionSort {

    static int arr[];


    public static void generateNumber(){
        int max = Integer.MAX_VALUE;
        arr = new int[100000001];
        int min = Integer.MIN_VALUE;
        int range = max - min +1;
        for(int i = 0 ; i <= 100000000; i++){
            int randomNumber = (int)(Math.random() * range) + min;
            arr[i] = randomNumber;
        }
    }

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
        generateNumber();
        insertionSortDecresingOrder(arr);

        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }
}
