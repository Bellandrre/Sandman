/**
 *
 * Converting an Integer to Roman requires me to understand the hardcoded values
 * values given - {I, V, X, L, C, D, M}
 * My values - {I, IV, V, IX, X, XL, L, XC, C, CD, CM, M}
 */


public class IntegerToRoman {

    private static final int values[] ={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1} ;
    //                                                             ^
    private static final String symbols[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String integerToRoman(int num){ // 1992
        StringBuilder strB = new StringBuilder();

        for(int i = 0 ; i < values.length && num > 0; i++){
            while(num >= values[i]){ // 92 >= 90
                num -= values[i];  // 92
                strB.append(symbols[i]); // MCMXCII
            }
        }
        return strB.toString();
    }
}
