package bg.tu_varna.sit.f24621905.task1;

class CrimeNovel extends Book {
    public CrimeNovel(String title, Author author, int publishingYear, double price, CoverType coverType) {
        super(title, author, publishingYear, price, coverType);
    }

    @Override
    public double calculateMargin() {
        return (getCoverType() == CoverType.hardcover) ? 0.02 * getPrice() : 0.01 * getPrice();
    }

    @Override
    public double getFinalPrice() {
        return getPrice() + calculateMargin();
    }
}
