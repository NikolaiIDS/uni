package bg.tu_varna.sit.f24621905.task1;

abstract class Book implements Margin {
    private final String title;
    private final Author author;
    private final int publishingYear;
    private final double price;
    private final CoverType coverType;

    public Book(String title, Author author, int publishingYear, double price, CoverType coverType) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.price = price;
        this.coverType = coverType;
    }


    public double getPrice() {
        return price;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public int getPublishingYear() {
        return publishingYear;
    }


    @Override
    public double calculateMargin() {
        return 0;
    }


    public abstract double getFinalPrice();


    @Override
    public String toString() {
        return new StringBuilder()
                .append(title)
                .append(" by ")
                .append(author)
                .append(" (")
                .append(publishingYear)
                .append("), Price: $")
                .append(getFinalPrice())
                .toString();
    }
}
