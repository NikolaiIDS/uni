package bg.tu_varna.sit.f24621905.task1;

public class PoetryBook extends Book {
    public PoetryBook(String title, Author author, int publishingYear, double price, boolean hasHardCover) {
        super(title, author, publishingYear, price, hasHardCover);
    }

    @Override
    public double calculateMargin() {
        if (hasHardCover && publishingYear > 2000) {
            return price * 0.01;
        } else {
            return price * 0.05;
        }
    }
}
