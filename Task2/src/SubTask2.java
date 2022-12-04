public class SubTask2 {

    public static int substrCount(String input, String needle, int offset, int length) {

        String inputShort = input.substring(offset, length + offset);
        int res = (inputShort.length() - inputShort.replace(needle, "").length()) / needle.length();
        return res;
    }


    public static void main(String[] args) {

          System.out.println(substrCount("Good Golly Miss Molly", "ll", 7, 10));

    }
}
