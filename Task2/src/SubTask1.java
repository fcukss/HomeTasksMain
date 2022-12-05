import java.util.Stack;

public class SubTask1 {

    public static boolean isOpen(char ch){
        //возрашаем true если ch равен таким условиям
        return  ch == '(' || ch == '[';
    }

    public static boolean isPair(char open, char close){
        //возращаем true если такие условия пары
        return  open == '(' && close == ')'||
                open == '[' && close == ']';
    }

    public static boolean testString(String str) {
        //удаляем буквы и цифры из строчки
        String s = str.replaceAll("[A-Za-z0-9]", "");
        //создаем стек для хранения скобок
        Stack<Character> stack = new Stack<>();

        //пробегаемся по строке
        for (int i = 0; i < s.length(); i++) {
            //если скобка открытa
            if (isOpen(s.charAt(i))) {
                //добавляем в стекы
                stack.push(s.charAt(i));
            } else {
                //если стек не пустой -> (для примера "]["
                //есть ли пара у элемента i и элемента что на вершине стека
                if (!stack.isEmpty() && isPair(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        //проверяем пустой ли стек. если пустой то true
        return stack.isEmpty();
    }

    public static void main(String[] args) {

//       System.out.println(testString("(isusyv(stc]ts(crs))cs)"));
     System.out.println(testString("sdgs(sfdbs[sgd]sdg)sd"));
    }
}
