public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(m == 0){
            nums1[0] = nums2[0];
            return;
        }
        int i = 0;
        int j = 0;
        int endIndex = m; // 8
        while( j < m && i < n){
            if(j < m &&  nums2[i] < nums1[j]){
                insertElement(nums1, nums2[i], j, endIndex++);
                i++;
            }else {
                j++;
            }
        }
        if(i != n){ // Copy the remaining array
            for(int k = j + 1; k < nums1.length; k++){
                nums1[k] = nums2[i++];
            }
        }
    }

    private static void insertElement(int inputArray[], int number, int index, int endIndex){

        for(int i = endIndex - 1; i >=  index; i--){ // 6
            int currNumber = inputArray[i];
            inputArray[i+1] = currNumber;
        }
        inputArray[index] = number;
    }

    public static void main(String[] args) {
        int nums1[] = {1,0};
        int nums2[] = {2};

        merge(nums1, 1, nums2, 1);

        for(Integer i : nums1){
            System.out.print(i + " ");
        }
    }

}
