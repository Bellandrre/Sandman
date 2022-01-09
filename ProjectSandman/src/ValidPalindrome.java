public class ValidPalindrome {

    public static boolean isPalindrome(String s){

        StringBuilder newStrb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);

            if(Character.isLetter(currChar) || Character.isDigit(currChar)){
                newStrb.append(currChar);
            }
        }

        String preprocessedString = newStrb.toString().toLowerCase();

        int i = 0;
        int j = preprocessedString.length() -1;

        while(i < j){
            if(preprocessedString.charAt(i)!= preprocessedString.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }
}
