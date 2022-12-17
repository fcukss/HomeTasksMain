
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SubTask4 {

    public static String convertString(String str) {

        List<String> words = Arrays.asList(str.split("[-.,:;()?!\"\\s–]+"));
        String temp = words.get(words.size() - 1);

        for (int n = words.size() - 1; n > 0; n--) {
            words.set(n, words.get(n - 1));
        }
        words.set(0, temp);

        return words
                .stream()
                .collect(Collectors.joining(" "));
    }

    public static void main(String str) {

        System.out.println(convertString(str));
    }
}

