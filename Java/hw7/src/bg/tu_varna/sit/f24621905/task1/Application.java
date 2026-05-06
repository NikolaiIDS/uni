package bg.tu_varna.sit.f24621905.task1;

public class Application {
    public static void main(String[] args) {
        System.out.println("----- Демонстрация на Система за Книжарница -----");

        Author king = new Author("Stephen", "King", "USA");
        Author rilke = new Author("Rainer", "Rilke", "Germany");
        Author asimov = new Author("Isaac", "Asimov", "Russia");
        Author bulgarianAuthor = new Author("Ivan", "Vazov", "Bulgaria");
        Author tolkien = new Author("J.R.R.", "Tolkien", "UK");

        Book book1 = new CrimeNovel("The Outsider", king, 2018, 25.50, CoverType.hardcover);
        Book book2 = new PoetryBook("The Book of Hours", rilke, 1905, 18.00, CoverType.paperback);
        Book book3 = new PoetryBook("Under the Yoke", bulgarianAuthor, 2022, 15.00, CoverType.hardcover);
        Book book4 = new SciFiNovel("Foundation", asimov, 1951, 35.90, CoverType.paperback);
        Book book5 = new SciFiNovel("I, Robot", asimov, 1950, 40.00, CoverType.hardcover);
        Book book6 = new CrimeNovel("IT", king, 1986, 30.00, CoverType.paperback);
        Book book7 = new SciFiNovel("The Hobbit", tolkien, 1937, 50.00, CoverType.paperback);


        System.out.println("\n--- Детайли за книгите и изчислените надценки ---");
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());
        System.out.println(book5.toString());
        System.out.println(book6.toString());
        System.out.println(book7.toString());

        Book[] bookInventory = {book1, book2, book3, book4, book5, book6, book7};
        Bookstore bookstore = new Bookstore(bookInventory);

        double total = bookstore.calculateTotalBookPrice();
        double average = bookstore.calculateAverageBookPrice();

        System.out.println("\n--- Резултати от Клас Bookstore ---");
        System.out.printf("Обща цена на всички книги (%d бр.): %.2f лв.\n", bookInventory.length, total);
        System.out.printf("Средна цена на книга: %.2f лв.\n", average);
        System.out.println("--------------------------------------------------");
    }
}