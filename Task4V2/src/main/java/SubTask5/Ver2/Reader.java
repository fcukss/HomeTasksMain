package SubTask5.Ver2;


import java.util.*;

public class Reader extends Thread {
    Random random = new Random();

    private String userName;
    List<Book> bookforReading = Collections.synchronizedList(new ArrayList<>());

    public Reader(String userName) {
        this.userName = userName;
        this.start();
    }

    public void takeBook(List<Book> list) {
        int count = random.nextInt(3);
        while (count > 0) {
            Book book = list.get(random.nextInt(list.size() - 1));
            if (book != null) {
                bookforReading.add(book);
                list.remove(book);
                System.out.println(userName + " take " + book.getBookName());
            }
            count--;
        }
    }

    public void read(Book book) {
        System.out.println(this.userName + " read " + book.getBookName());

    }

    public void takeHome(Book book) {
        System.out.println(this.userName + " take home " + book.getBookName());
    }

    public void giveBack(Book book) {
        bookforReading.remove(book);
        System.out.println(this.userName + " give back " + book.getBookName());
        Library.books.add(book);
    }

    @Override
    public void run() {
        try {
            takeBook(Library.books);
            if (bookforReading.size() != 0) {
                for (int i = 0; i < bookforReading.size(); i++) {
                   Book b = bookforReading.get(i);
                    if (b.isMarker()) {
                        read(b);
                        Thread.sleep(random.nextInt(4000));
                        System.out.println(this.userName + " stop read " + b.getBookName());
                        giveBack(b);
                        i--;
                    } else {
                        takeHome(b);
                    }
                }
            } else {
                System.out.println("Книг для чтения нет");
            }
            System.out.println(userName+" leave library with " + bookforReading.size() + " book(s)");
        } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
        } catch (ConcurrentModificationException e) {
            Thread.currentThread().interrupt();
        }
    }
}
