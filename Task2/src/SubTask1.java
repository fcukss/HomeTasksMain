import java.util.Stack;

public class SubTask1 {

    public static boolean isOpen(char ch){
        return  ch == '(' || ch == '[';
    }

    public static boolean isPair(char open, char close){
        return  open == '(' && close == ')'||
                open == '[' && close == ']';
    }

    public static boolean testString(String str) {
        String s = str.replaceAll("[A-Za-z0-9]", "");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (isOpen(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && isPair(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
     System.out.println(testString("sdgs(sfdbs[sgd]sdg)sd"));
    }
}
