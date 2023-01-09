package SubTask1;

public class Program {
    public static void main(String[] args) {

        Book book = new Dictionary("qwerty", "Java", "Frimmen",
                "O'Reilly", 2010);
        System.out.println(book);

        Book encyclpop = new Encyclopedia("ytrewq", "Nature", "Author",
                "KharkovPrint", 2015);
        System.out.println(encyclpop);

    }
}
