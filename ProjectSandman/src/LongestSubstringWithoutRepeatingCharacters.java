
import java.util.HashMap;
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * This one uses HashMap
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>(); // <Non Repeating, index>
        int maxLen = 0;

        int fwdPtr = 0;
        int bckPtr = 0;

        while(fwdPtr < s.length()){
            char curr = s.charAt(fwdPtr);

            if(map.containsKey(curr)){
                map.remove(s.charAt(bckPtr));
                bckPtr++;

            }else{
                map.put(curr, fwdPtr);
                fwdPtr++;
                maxLen = Math.max(maxLen, map.size());
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
