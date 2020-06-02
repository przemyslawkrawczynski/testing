package pl.pk.testing.qc.collections.sets.adv.immutable;

import org.junit.Test;
import pl.pk.testing.qc.collections.adv.immutable.special.Book;
import pl.pk.testing.qc.collections.adv.immutable.special.BookManager;

import static org.assertj.core.api.Assertions.assertThat;


public class BookManagerTestSuits {

    @Test
    public void should_get_existing_book_if_the_same_exists_in_set() {

        BookManager bookManager = new BookManager();

        Book b1 = bookManager.createBook("Pan Tadeusz", "Adam Mickiewicz");
        Book b2 = bookManager.createBook("Potop", "Heniek Sienkiewicz");
        Book b3 = bookManager.createBook("Mały Książe", "A. E");
        Book b3_copied = bookManager.createBook("Mały Książe", "A. E");

        assertThat(b1 == b2).isFalse();
        assertThat(b1 == b3).isFalse();
        assertThat(b2 == b3).isFalse();
        assertThat(b3 == b3_copied).isTrue();

    }

}
