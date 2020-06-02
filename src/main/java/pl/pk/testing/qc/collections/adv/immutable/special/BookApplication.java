package pl.pk.testing.qc.collections.adv.immutable.special;

public class BookApplication {

    public static void main(String[] args) {

        BookManager bookManager = new BookManager();

        Book b1 = bookManager.createBook("Pan Tadeusz", "Adam Mickiewicz");
        Book b2 = bookManager.createBook("Potop", "Heniek Sienkiewicz");
        Book b3 = bookManager.createBook("Mały Książe", "A. E");
        Book b3_copied = bookManager.createBook("Mały Książe", "A. E");

        System.out.println(b1 == b2);
        System.out.println(b1 == b3);
        System.out.println(b2 == b3);
        System.out.println(b3 == b3_copied);
    }
}
