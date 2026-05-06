package bg.tu_varna.sit.f24621905.task1;

class PoetryBook extends Book {
    public PoetryBook(String title, Author author, int publishingYear, double price, CoverType coverType) {
        super(title, author, publishingYear, price, coverType);
    }

    @Override
    public double calculateMargin() {
        if (getCoverType() == CoverType.hardcover && getPublishingYear() > 2000) {
            return 0.01 * getPrice();
        } else {
            return 0.05 * getPrice();
        }
    }

    @Override
    public double getFinalPrice() {
        return getPrice() + calculateMargin();
    }
}