package Arrays;

public class LongestPeak {

    public static int longestMountain(int[] arr) {
        if(arr.length < 3){
            return 0;
        }
        int len = arr.length;
        int i = 0;
        int maxPeak = 0;
        boolean isIncreasing = false;
        boolean isDecreasing = false;

        while(i < arr.length - 1){
            if(arr[i] < arr[i+1]){
                // if it is increasing then keep on climbing until we find a decrease
                int start = i;
                while(i < len - 1 && arr[i] < arr[i+1]){
                    i++;
                    isIncreasing = true;
                }
                while(i < len - 1 && arr[i] > arr[i+1]){
                    i++;
                    isDecreasing = true;
                }

                if(isIncreasing && isDecreasing){
                    int currLength = (i - start) +1;
                    maxPeak = Math.max(currLength, maxPeak);
                }
                isIncreasing = false;
                isDecreasing = false;
            }else{
                i++;
            }
        }
        return maxPeak;
    }

    public static void main(String[] args) {
        int arr[] = { 2,1,4,7,3,2,5};
        System.out.println(longestMountain(arr));
    }
}
