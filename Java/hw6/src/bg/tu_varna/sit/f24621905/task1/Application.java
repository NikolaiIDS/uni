package bg.tu_varna.sit.f24621905.task1;

public class Application {
    public static void main(String[] args) {
        Author author1 = new Author("Agatha", "Christie", "UK");
        Author author2 = new Author("Isaac", "Asimov", "Russia");
        Author author3 = new Author("Agatha", "Christie", "UK");

        Book[] books = {
                new CrimeNovel("Murder on the Orient Express", author1, 1934, 20.0, true),
                new PoetryBook("Modern Poems", new Author("John", "Doe", "USA"), 2010, 15.0, true),
                new SciFiNovel("Foundation", author2, 1951, 25.0, false)
        };

        Bookstore bookstore = new Bookstore(books);

        System.out.println("Total price: " + bookstore.calculateTotalBookPrice());
        System.out.println("Average price: " + bookstore.calculateAverageBookPrice());
        System.out.println("Author1 is same as Author3: " + author1.compare(author3));
    }
}
