package SubTask1;

class Dictionary extends Book {

    public Dictionary(String code, String name, String author, String publisher, int year) {
        super(code, name, author, publisher, year);
    }

    @Override
    public String toString() {
        return String.format("Dictionary : " +
                "name - %s, " +
                "author - %s," +
                "year - %d," +
                "publisher - %s\n", getName(),getAuthor(),getYear(),getPublisher());
    }
}
