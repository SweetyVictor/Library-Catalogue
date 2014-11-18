package ic.doc;

import ic.doc.catalogues.Catalogue;
import ic.doc.catalogues.Searchable;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookSearchQueryTest {

    // Create a smaller catalogue for faster search test
    private final Searchable smallCatalogue = new Catalogue() {
        @Override
        protected Collection<Book> allTheBooks() {
            return Arrays.asList(
                    new Book("A Tale of Two Cities", "Dickens"),
                    new Book("Pride and Prejudice", "Austen"),
                    new Book("Brave New World", "Huxley"));
        }
    };

    @Test
    public void allowsLookingUpBooksByAuthor() {

        List<Book> books = new BookSearchQuery("dickens", smallCatalogue).execute();
        assertThat(books.size(), is(greaterThan(0)));
        for (Book book : books) {
            assertTrue(book.isWrittenBy("dickens"));
        }

    }

}
