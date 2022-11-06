public class SubTask5 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        for (int i = 2; i <= n; i++) {
            int res = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    res = 0;
                    break;
                }
            }
            if (res != 0)
                System.out.print(res + " ");
        }
        System.out.println();
    }
}


