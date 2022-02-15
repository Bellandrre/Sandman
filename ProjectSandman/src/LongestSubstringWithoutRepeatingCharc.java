import java.util.*;
public class LongestSubstringWithoutRepeatingCharc {

    public static String longestSubtring(){

        int fwdPtr = 0;
        int bckPtr = 0;

        Set<Character> seen = new HashSet<>();

        // x y y z y z y x
        //           ^
        //               ^
        // 3
        // 3
        // < y 2, z 1, x 1 >
        // 3 - 0 + 1 = 4
        // 7 - 5 + 1 = 3


        return "";
    }



    public static void main(String[] args) {

    }

}
