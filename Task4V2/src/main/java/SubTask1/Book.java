package SubTask1;

public abstract class Book {

    private String code;
    private String name;
    private String author;
    private String publisher;
    private int year;

    public Book(String code, String name, String author, String publisher, int year) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }
}

