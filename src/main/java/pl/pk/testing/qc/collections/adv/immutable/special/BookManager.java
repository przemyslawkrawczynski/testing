package pl.pk.testing.qc.collections.adv.immutable.special;

import java.util.HashSet;
import java.util.Set;

public class BookManager {

    private Set<Book> books = new HashSet<>();

    public Book createBook(String title, String author) {

        Book book = getIfExist(title, author);

        if (book == null) {
            book = new Book(title, author);
            books.add(book);
        }

        return book;
    }

    private Book getIfExist(String title, String author) {

        Book existingBook = null;

        for (Book book: books) {
            if (book.getAuthor().equals(author) && book.getTitle().equals(title)) {
                existingBook = book;
            }
        }

        return existingBook;
    }

}
