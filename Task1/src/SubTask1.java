import java.util.Arrays;
import java.util.Locale;

public class SubTask1 {
    public static void main(String[] args) {
        Locale lc = new Locale("UK","UA");
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double sum = a+b;
        System.out.printf( lc,"%.1f",sum);
        System.out.println();
    }
}
