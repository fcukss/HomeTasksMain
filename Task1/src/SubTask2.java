public class SubTask2 {
    public static void main(String[] args) {

        StringBuilder concat = new StringBuilder();

        for (String temp : args) {

            concat.append(temp).append(" ");
        }

        System.out.println(concat.toString().trim());
    }
}
