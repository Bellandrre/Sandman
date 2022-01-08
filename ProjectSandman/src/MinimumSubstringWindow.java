public class MinimumSubstringWindow {

    private static final int totalNoCharacrters = 256;

    public static String minWindow(String str, String pat){
        int length_1 = str.length();
        int length_2 = pat.length();

        int string[]  = new int[totalNoCharacrters];
        int pattern[] = new int[totalNoCharacrters];

        if(length_1 < length_2)
            return "";

        for(int i = 0 ; i < length_2; i++)
            pattern[pat.charAt(i)]++;

        int count = 0;
        int start = 0;
        int minWindowLen = Integer.MAX_VALUE;
        int start_index = -1;

        for(int i = 0 ; i < length_1; i++){

            string[str.charAt(i)]++;

            if(string[str.charAt(i)] <= pattern[str.charAt(i)]){
                count++;
            }

            if(count == length_2){

                while(string[str.charAt(start)] > pattern[str.charAt(start)] || pattern[str.charAt(start)] == 0){
                    if(string[str.charAt(start)] > pattern[str.charAt(start)]){
                        string[str.charAt(start)]--;
                    }
                    start++;
                }


                int windowLength = i - start + 1;

                if(windowLength < minWindowLen){
                    minWindowLen = windowLength;
                    start_index = start;
                }
            }


        }
        return str.substring(start_index, start_index + minWindowLen );
    }


    public static void main(String[] args) {
        String inputStr = "ADAAABECODEBANC";
        String pattern = "ABC";
        System.out.println(minWindow(inputStr, pattern));
    }
}
