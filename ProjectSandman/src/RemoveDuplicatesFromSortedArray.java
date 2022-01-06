public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int fwdPtr = 0;
        int bckPtr = 0;

        while(fwdPtr < nums.length){
            if(nums[bckPtr] !=  nums[fwdPtr]){
                nums[++bckPtr] = nums[fwdPtr];
            }
            fwdPtr++;
        }
        return bckPtr+1;
    }

    public static void main(String[] args) {
        int inputArray[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(inputArray));
    }

}
