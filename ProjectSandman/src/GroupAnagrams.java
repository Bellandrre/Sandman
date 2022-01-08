import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> anagramGroupMapping = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for(int i = 0 ; i < strs.length; i++){
            String currentWord = strs[i];
            String sortedWord = sortString(currentWord);

            if(anagramGroupMapping.containsKey(sortedWord)){
                List<String> groupedAnagram = anagramGroupMapping.get(sortedWord);
                groupedAnagram.add(currentWord);
                anagramGroupMapping.put(sortedWord, groupedAnagram);
            }else{
                List<String> groupedAnagram = new ArrayList<>();
                groupedAnagram.add(currentWord);
                anagramGroupMapping.put(sortedWord, groupedAnagram);
            }
        }

        for(List<String> groupedAnagrams : anagramGroupMapping.values()){
            resultList.add(groupedAnagrams);
        }

        return resultList;

    }

    private static String sortString(String input){
        char inputCharArray[] = input.toCharArray();
        Arrays.sort(inputCharArray);
        return new String(inputCharArray);
    }

    public static void main(String[] args) {
        String inputStr[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(inputStr).toString());
    }
}
