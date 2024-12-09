import java.time.LocalDate;

public class Magazine extends LibraryItem {
    private LocalDate issueDate;
    private String publisher;
    private double lateFeePerDay;

    public Magazine(String id, String title, boolean available, LocalDate issueDate, String publisher, double lateFeePerDay) {
        super(id, title, available);
        this.issueDate = issueDate;
        this.publisher = publisher;
        this.lateFeePerDay = 1.0;
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * lateFeePerDay;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getPublisher() {
        return publisher;
    }
}
