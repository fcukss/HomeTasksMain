package SubTask1;

class Encyclopedia extends Book {

    public Encyclopedia(String code, String name, String author, String publisher, int year) {
        super(code, name, author, publisher, year);
    }

    @Override
    public String toString() {
        return String.format("Encyclopedia : " +
                "name - %s, " +
                "author - %s," +
                "year - %d," +
                "publisher - %s\n", getName(),getAuthor(),getYear(),getPublisher());
    }
}
