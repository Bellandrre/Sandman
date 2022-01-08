public class AddBinaryCorrectSolution {

    public static String addBinary(String numB1, String numB2){
        StringBuilder strB = new StringBuilder();
        int i = numB1.length() - 1;
        int j = numB2.length() - 1;
        int sum = 0;
        int carry = 0;
        while(i >= 0 || j >=0){
            sum = carry;
            if(i >= 0) sum += numB1.charAt(i) - '0';
            if(j >= 0) sum += numB2.charAt(j) - '0';
            strB.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }

        if(carry != 0) strB.append(carry);

        return strB.reverse().toString();
    }
}
