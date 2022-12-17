import java.util.*;
import java.util.stream.Collectors;

public class SubTask3 {

    public static Integer numOfChars(String str, char ch) {
        Integer count = 0;
        for (char el : str.toCharArray())
            if (el == ch)
                count++;
        return count;
    }

    public static void words(String text, char l){

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = Arrays
                .stream(text
                        .toLowerCase()
                        .split("[-.,:;()?!\"\\s–]+"))
                .collect(Collectors.toSet());

        for (String key : set)
            map.put(key, numOfChars(key, l));

        StringBuilder sb = new StringBuilder();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed());

         Set<String> words = map.keySet();
        for (String word : words)
            System.out.printf("%s - %d\n", word, map.get(word));
    }

    public static void main(String text, char l) {
        words(text,l);
    }
}
