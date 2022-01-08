public class AddBinary {

    // Works on small numbers
    public static String addBinary(String numB1, String numB2){
        Integer result = getDecimal(numB1) + getDecimal(numB2);
        return getBinary(result.toString());
    }

    private static Integer getDecimal(String numB){
        int result = 0;
        int currentPower = 0;

        for(int i = numB.length() - 1 ; i >= 0; i--){
            int currNum = numB.charAt(i) - '0';
            result += currNum * Math.pow(2, currentPower++);
        }

        return result;
    }

    private static String getBinary(String numD){
        StringBuilder result = new StringBuilder();
        int givenNumber = Integer.parseInt(numD);
        if(givenNumber == 0) return "0";
        while(givenNumber > 0){
            result.append(givenNumber%2);
            givenNumber /= 2;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("0", "0"));
    }

}
