import java.util.ArrayList;

public class SubTask5 {

  public static String convertToSentence(String text, int limit){

        String[] words = text.replaceAll("\n", " ").split("(?=[\\s\\.])");
        ArrayList<String> array = new ArrayList<>();
        int i = 0;
        while (words.length > i) {
            StringBuilder line = new StringBuilder();
            while (words.length > i && line.length() + words[i].length() < limit) {
                line.append(words[i]);
                i++;
            }
            array.add(line.toString());
        }

        StringBuilder sb = new StringBuilder();
        array.forEach(s -> sb.append(s.trim()).append("\n"));

      return sb.toString();
    }

    public static void main(String args, int limit) {

        System.out.println(convertToSentence(args,limit));

    }
}
