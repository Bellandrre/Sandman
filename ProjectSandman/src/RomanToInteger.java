import java.util.HashMap;
public class RomanToInteger {
    private static final HashMap<String, Integer> symbolInteger = new HashMap<>();

    private static void constructMap(){
        symbolInteger.put("I",1);
        symbolInteger.put("IV",4);
        symbolInteger.put("V",5);
        symbolInteger.put("IX",9);
        symbolInteger.put("X",10);
        symbolInteger.put("XL",40);
        symbolInteger.put("L",50);
        symbolInteger.put("XC",90);
        symbolInteger.put("C", 100);
        symbolInteger.put("CD", 400);
        symbolInteger.put("D", 500);
        symbolInteger.put("CM", 900);
        symbolInteger.put("M", 1000);
    }
    public static int romanToInt(String s) {
        constructMap();
        int fwdPtr = 0;
        int stringLength = s.length();
        int result = 0;

        while(fwdPtr < stringLength){
            String currNumber = "";
                    if(fwdPtr + 1 <  stringLength) {
                        currNumber = s.substring(fwdPtr, fwdPtr + 2);
                    }
            if(symbolInteger.containsKey(currNumber)){
                result += symbolInteger.get(currNumber);
                fwdPtr += 2;
            }else{
                result += symbolInteger.get(s.charAt(fwdPtr) + "");
                fwdPtr++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

}
