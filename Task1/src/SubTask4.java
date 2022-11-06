public class SubTask4 {
    public static void main(String[] args) {

        String str = args[args.length - 1];
        int length = str.length();
        int x = Integer.parseInt(str);
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int temp = x % 10;
            x = x / 10;
            sum = sum + temp;
        }
        System.out.println(sum);

    }
}
