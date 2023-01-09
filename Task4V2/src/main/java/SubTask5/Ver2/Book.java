package SubTask5.Ver2;

public class Book {
    private String bookName;
    private boolean marker = false;

    public Book(String bookName, boolean marker) {
        this.bookName = bookName;
        this.marker = marker;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isMarker() {
        return marker;
    }

    @Override
    public String toString() {
        return "bookName = " + bookName + " , marker= " + marker;
    }
}
