package Arrays;

public class ArrayOfProducts {
    public static  int[] arrayOfProducts(int[] array) {

        // Write your code here.
        int aux_1[] = new int[array.length];
        int aux_2[] = new int[array.length];
        aux_1[0] = 1;
        aux_2[array.length - 1] = 1;

        for(int i = 1 ; i < array.length ; i++){
            aux_1[i] = array[i - 1] * aux_1[i - 1];
            System.out.println(aux_1[i]);
        }

        for(int i = array.length -2; i >=0; i--){
            aux_2[i] = array[i + 1] * aux_2[i + 1];
            System.out.println(aux_2[i]);
        }

        for(int i = 0 ; i < array.length; i++){
            aux_1[i] = aux_1[i] * aux_2[i];
        }

        return aux_1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 2};
        arrayOfProducts(arr);
    }
}
