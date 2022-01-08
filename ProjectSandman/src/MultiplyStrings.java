
public class MultiplyStrings {

    public static String multiplyString(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);


        firstNumber.reverse();
        secondNumber.reverse();

        int n = firstNumber.length() + secondNumber.length();
        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < n; i++){
            answer.append(0);
        }

        for(int place2 = 0; place2 < secondNumber.length(); place2++){
            int digit2 = secondNumber.charAt(place2) - '0';

            for(int place1 = 0; place1 < firstNumber.length(); place1++){
                int digit1 = firstNumber.charAt(place1) - '0';

                int currentPosition = place1 + place2;

                int carry = answer.charAt(currentPosition) - '0';
                int multiplication = (digit1 * digit2) + carry;

                answer.setCharAt(currentPosition,(char) (multiplication%10 + '0'));

                int value = (answer.charAt(currentPosition + 1) - '0') + multiplication / 10;
                answer.setCharAt(currentPosition + 1, (char)(value + '0'));
            }
        }

        if(answer.charAt(answer.length() - 1 ) == '0'){
            answer.deleteCharAt(answer.length() - 1);
        }

        answer.reverse();
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiplyString("123", "456"));
    }

}
