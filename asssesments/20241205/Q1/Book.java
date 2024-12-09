public class Book extends LibraryItem{
    private String author;
    private String isbn;
    private double lateFeePerDay;

    public Book(String id, String title, boolean available, String author, String isbn, double lateFeePerDay) {
        super(id, title, available);
        this.author = author;
        this.isbn = isbn;
        this.lateFeePerDay = 2.0;
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * lateFeePerDay;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
