package bg.tu_varna.sit.f24621905.task1;

public class CrimeNovel extends Book {
    public CrimeNovel(String title, Author author, int publishingYear, double price, boolean hasHardCover) {
        super(title, author, publishingYear, price, hasHardCover);
    }

    @Override
    public double calculateMargin() {
        if (hasHardCover) {
            return price * 0.02;
        } else {
            return price * 0.01;
        }
    }
}
