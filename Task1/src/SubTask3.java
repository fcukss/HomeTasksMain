public class SubTask3 {
    public static void main(String[] args) {

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        
        System.out.println(x);
    }
}
