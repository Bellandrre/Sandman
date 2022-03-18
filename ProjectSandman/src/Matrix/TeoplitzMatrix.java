package Matrix;

public class TeoplitzMatrix {

    public static boolean isTeoplitzMatrix(int arr[][]){
        /**
           *  startVal = 2
           *      i
           * [1,  2,  3,  4]
         j * [5,  1,  2,  3]
           * [6,  5,  1,  2]
           * [7,  6,  5,  1]
           */

        /**
         i * [1,2,3,4]
           * [1,2,3,5]
           * [1,2,6,5]
           */

        int cols = arr[0].length;

        for(int i = 0; i < cols - 1; i++){
            boolean isValid = checkUpDiagonal(arr, i);
            if(!isValid)
                return false;
        }

        for(int i = cols - 2; i >=0; i--){
            boolean isValid = checkLowDiagonal(arr, i);
            if(!isValid)
                return false;
        }

        return true;
    }

    public static boolean checkUpDiagonal(int arr[][],int i){
        int startVal = arr[0][i];
        i++;
        for(int j = 1; j < arr.length; j++){
            if( i < arr[0].length && startVal != arr[j][i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean checkLowDiagonal(int arr[][], int i){
        int startVal = arr[arr.length - 1][i];
        i--;
        for(int j = arr.length - 2; j > 0; j--){
            if( i >=0 && startVal != arr[j][i])
                return false;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        int inputArr[][] = {{8, 8, 8, 8, 8},
                            {8, 8, 8, 8, 9},
                            {8, 8, 8, 8, 8},
                            {8, 8, 8, 8, 8}};


        System.out.println(isTeoplitzMatrix(inputArr));

    }

}
