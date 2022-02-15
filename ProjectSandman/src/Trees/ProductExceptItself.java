package Trees;

public class ProductExceptItself {

    public static int[] productExceptItself(int nums[]){
        int N = nums.length;

        int auxA[] = new int[N];
        auxA[0] = 1;

        int auxB[] = new int[N];
        auxB[N -1] = 1;



        for(int i = 1 ; i < N; i++){
            auxA[i] = nums[i -1] * auxA[i - 1];
        }

        for(int j= N - 2; j >= 0; j--){
            auxB[j] = nums[j + 1] * auxB[j+1];
        }

        for(int i = 0 ; i < N; i++){
            nums[i] = auxA[i] * auxB[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {4, 5, 1, 8, 2};
        int newNums[] = productExceptItself(nums);

        for(Integer i : newNums){
            System.out.print(i + " ");
        }
    }


}
