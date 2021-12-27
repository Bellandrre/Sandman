public class NextPermutation {


    public static void nextPermutation(int[] nums){
        int bckPtr = nums.length - 2;
        int fwdPtr = 0;

        while( bckPtr >= 0 && nums[bckPtr + 1] <= nums[bckPtr] ){
            bckPtr--;
        }

        if(bckPtr >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[bckPtr]){
                j--;
            }
            swap(nums, bckPtr, j);
        }

        reverse(nums, bckPtr + 1);
    }

    public  static void swap(int nums[], int bckPtr, int j){
        nums[bckPtr] = nums[bckPtr] ^ nums[j];
        nums[j]      = nums[bckPtr] ^ nums[j];
        nums[bckPtr] = nums[bckPtr] ^ nums[j];
    }

    public static void reverse(int nums[], int bckPtr){
        int i = bckPtr, j = nums.length -1;

        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(nums);

        for(Integer i : nums){
            System.out.println(i);
        }
    }

}
