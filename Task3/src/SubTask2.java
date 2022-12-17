import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SubTask2 {

    private static char[] encrypt(String text){
        char[] chars = text.toCharArray();

        List<Character> list = new ArrayList<>();
        list.add(chars[0]);

        Function<Integer,List<Character>> getLoop = (x)->{
            for(int i=x; i<chars.length; i+=3){
                list.add(chars[i]);
            }
            return list;
        };

        StringBuilder sb = new StringBuilder();

        getLoop.apply(1);
        getLoop.apply(2);
        getLoop.apply(3);

        list.forEach(sb::append);

        return sb.toString().toCharArray();

    }


    public static void main(String args) {

        System.out.println(encrypt(args));

    }
}
