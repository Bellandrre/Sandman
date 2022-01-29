package Sorting;
/*
The insertion sort is efficient for small number of elements. It can be used when the arr is almost sorted.
The best case of insertion sort is = O(n)
The worst case of insertion sort is = O(n^2) when the elements are in reverse sorted order.
Sorting : In place
Stable : Yes
Online: Yes (Elements to be sorted are provided one at a time. The algorithm is not provied with the whole input at once. The input comes one after the other)
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
