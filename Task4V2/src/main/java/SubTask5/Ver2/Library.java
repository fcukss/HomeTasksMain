package SubTask5.Ver2;

import java.util.*;

public class Library {

    Random random = new Random();
    public static List<Book> books = Collections.synchronizedList(new ArrayList<>());

    private final int COUNTofBOOKS = 10;

    public Library() {
        for (int i = 1; i <= COUNTofBOOKS; i++) {
            books.add(new Book("book-" + i, random.nextBoolean()));
        }
    }

}

