package bg.tu_varna.sit.f24621905.task1;

public abstract class Book implements Margin {
    private String title;
    private Author author;
    protected int publishingYear;
    protected double price;
    protected boolean hasHardCover;

    public Book(String title, Author author, int publishingYear, double price, boolean hasHardCover) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.price = price;
        this.hasHardCover = hasHardCover;
    }

    public double getFinalPrice() {
        return price + calculateMargin();
    }

    @Override
    public String toString() {
        return author + ": " + title;
    }
}
