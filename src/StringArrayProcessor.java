import java.util.*;
public class StringArrayProcessor {
    public static void process(String[] source){

        // In this map Keys are strings containing sorted characters of strings from source
        // array and Value are Lists containing counter of strings with the same character sets in
        // the first position and its indexes in all other positions.
        Map<String, ArrayList<Integer>> countedSortedStrings = new HashMap<>();
        Set<String> keys = new HashSet<>();
        for(int i = 0; i < source.length; i++){
            var chars = source[i].toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (!countedSortedStrings.containsKey(sortedString)){
                ArrayList<Integer> value = new ArrayList<>();
                value.add(1);
                value.add(i);
                countedSortedStrings.put(sortedString, value);
                keys.add(sortedString);
            }
            else{
                List<Integer> newValue = countedSortedStrings.get(sortedString);
                newValue.set(0, newValue.get(0) + 1);
                newValue.add(i);
            }
        }
        for (var key: keys){
            List<Integer> values = countedSortedStrings.get(key);

            // Print strings with same characters
            if (values.get(0) > 1){
                StringBuilder toPrint = new StringBuilder(key + ": ");
                toPrint.append(values.get(1));
                for(int i = 2; i < values.size(); i++){
                    toPrint.append(", ").append(values.get(i));
                }
                System.out.println(toPrint);
            }
        }
    }
}