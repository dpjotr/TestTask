import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Contains method for processing of String array.
public class StringArrayProcessor {
    public static void process(String[] source){

        Map<String, Anagramma> countedSortedStrings = new HashMap<>();
        for(int i = 0; i < source.length; i++){
            String sortedString = Stream.of( source[i].split("") )
                    .sorted()
                    .collect(Collectors.joining());
            if (!countedSortedStrings.containsKey(sortedString)){
                Anagramma anagramma = new Anagramma(i);
                countedSortedStrings.put(sortedString, anagramma);
            }
            else{
                countedSortedStrings.get(sortedString).counter++;
                countedSortedStrings.get(sortedString).positions.append(", ").append(i);
            }
        }
        for (var keyValue: countedSortedStrings.entrySet()){

            // Print strings with same characters
            if (keyValue.getValue().counter > 1){
                System.out.println(
                        keyValue.getValue()
                                .positions.insert(0, keyValue.getKey() + "= "));
            }
        }
    }
}
class Anagramma{
    int counter = 1;
    StringBuilder positions = new StringBuilder();
    Anagramma(int position){
        positions.append(position);
    }
}