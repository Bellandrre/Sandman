public class myAtoiFunction {

    public static int myAtoI(String str){
        String newString;
        int sign;
        int newlyFormedInt;

        // Rule 1 read and ignore any leading whitespace
        newString = str.trim();

        // Rule 2 sign
        sign = newString.charAt(0) == '-' ? -1 : 1;


        // Rule 3 read until the first non numerical or end of string
        for(int i = 0 ; i < newString.length(); i++){
            if(newString.charAt(i) != '+' && newString.charAt(i) != '-'  && (newString.charAt(i) < 48 || newString.charAt(i) > 57) ){
                newString = newString.substring(0, i);
                break;
            }
        }


        // Rule 4, 5 0032 --> 32
        try {
            newlyFormedInt = Integer.parseInt(newString);
        }catch(Exception e){
            newlyFormedInt = sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return newlyFormedInt;
    }

    public static void main(String[] args) {
        System.out.println(myAtoI("-4193 with words"));
    }
}
