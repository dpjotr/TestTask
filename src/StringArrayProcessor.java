import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Contains method for processing of String array.
public class StringArrayProcessor {
    public static void process(String[] source){

        Map<String, StringBuilder> countedSortedStrings = new HashMap<>();
        for(int i = 0; i < source.length; i++){
            String sortedString = Stream.of( source[i].split("") )
                    .sorted()
                    .collect(Collectors.joining());
            if (!countedSortedStrings.containsKey(sortedString)){
                countedSortedStrings.put(sortedString, new StringBuilder().append(i));
            }
            else{
                countedSortedStrings.get(sortedString).append(", ").append(i);
            }
        }
        for (var keyValue: countedSortedStrings.entrySet()){

            if (keyValue.getValue().toString().contains(",")){
                System.out.println(
                        keyValue.getValue()
                                .insert(0, keyValue.getKey() + "= "));
            }
        }
    }
}