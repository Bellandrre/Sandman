public class NextPermutation {
    // [1, 4, 5, 4, 1, 2, 2, 6]
    //                 ^
    public static void nextPermutation(int[] nums) {
        int bckPtr = nums.length - 2;

        while(bckPtr >= 0 && nums[bckPtr +1] <= nums[bckPtr]){
            bckPtr--;
        }

        if(bckPtr >= 0){
            int justGreaterNumber = nums.length - 1;
            while(nums[bckPtr] >= nums[justGreaterNumber]) justGreaterNumber--;
            swap(bckPtr, justGreaterNumber, nums);
        }
        reverse(bckPtr + 1, nums.length - 1, nums);
    }

    public static void swap(int i, int j, int nums[]){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void reverse(int i, int j, int nums[]){
        while(i < j){
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int array[] = {1, 4, 5, 2, 6, 4, 2, 1};
        nextPermutation(array);
        System.out.println(array);
    }
}
