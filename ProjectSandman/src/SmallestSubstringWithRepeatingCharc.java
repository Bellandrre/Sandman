import java.util.Map;
import java.util.HashMap;

/**
 *
 * Two pointer approach
 * Try to decrease the siz eof the window when all of the unique elements are found.
 * Time Complexity - O(M+N)
 * Space Complexity - O(M) - Number of unique characters
 */


public class SmallestSubstringWithRepeatingCharc {

    public static String getShortestUniqueSubstring(char[] arr, String str){

        int totalChar = arr.length;
        Map<Character, Integer> freqMap = new HashMap<>();
        int characterMatchCount = 0;
        int fwdPtr = 0;
        int bckPtr = 0;
        int minLength = Integer.MAX_VALUE;

        int fwdResult = 0;
        int bckResult = 0;

        // x  y  y  z  y  z  y  x
        //             ^
        //    ^
        //count 2
        // Map
        // x - 0
        // y - 3
        // z - 1

        while(fwdPtr < str.length()){
            char currChar = str.charAt(fwdPtr);

            if(freqMap.containsKey(currChar)){
                freqMap.put(currChar, freqMap.get(currChar)+1);
            }else{
                freqMap.put(currChar, 1);
                characterMatchCount++;
            }

            // Try to decrease the window size
            if(characterMatchCount == totalChar){
                while(bckPtr < fwdPtr){

                    char currBackChar = str.charAt(bckPtr); // y

                    if(freqMap.get(currBackChar) == 1){
                        characterMatchCount--;

                        freqMap.remove(currBackChar);

                        if(minLength > (fwdPtr - bckPtr) + 1){
                            minLength = (fwdPtr - bckPtr) + 1;
                            bckResult = bckPtr;
                            fwdResult = fwdPtr;
                        }
                        bckPtr++;
                        break;

                    }else {

                        freqMap.put(currBackChar, freqMap.get(currBackChar) - 1);
                        bckPtr++;

                    }
                }
            }
            fwdPtr++;
        }
        return str.substring(bckResult, fwdResult + 1);
    }

    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring("xyz".toCharArray(), "xyyzyzyx"));
    }

}
