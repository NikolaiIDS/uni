package bg.tu_varna.sit.f24621905.task1;

public class SciFiNovel extends Book {
    public SciFiNovel(String title, Author author, int publishingYear, double price, boolean hasHardCover) {
        super(title, author, publishingYear, price, hasHardCover);
    }

    @Override
    public double calculateMargin() {
        if (!hasHardCover) {
            return price * 0.09;
        } else {
            return price * 0.12;
        }
    }
}
