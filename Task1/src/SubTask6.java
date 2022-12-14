public class SubTask6 {

    static final int NUM_OF_SYMBOLS = 26;
    static final int START_SYMBOL = 64;

    public static int numberOfColumn(String number) {

        int position = 0;
        int length = number.length();
        for (int i = 0; i < length; i++) {
            char firstSymbol = number.charAt(i);
            int tempPosition = firstSymbol - START_SYMBOL;
            position = (int) (position + Math.pow(NUM_OF_SYMBOLS, length - 1 - i) * tempPosition);
        }
        return position;
    }


    public static String charOfColumn(int number) {
        StringBuilder result = new StringBuilder();
        int a = number;
        while (number > 0) {
            a = (number - 1) / NUM_OF_SYMBOLS;
            int b = (number - 1) % NUM_OF_SYMBOLS;
            result.append((char) (b + START_SYMBOL + 1));
            number = a;
        }
        return result.reverse().toString();
    }

    public static int rightColumn(String number) {
        return numberOfColumn(number) + 1;
    }


    public static void main(String[] args) {

        System.out.println(numberOfColumn("AAA"));
        System.out.println(charOfColumn(731));
        System.out.println(rightColumn("AAA"));
    }
}
