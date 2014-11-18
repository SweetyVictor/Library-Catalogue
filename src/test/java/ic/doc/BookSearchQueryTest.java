package ic.doc;

import ic.doc.catalogues.BritishLibraryCatalogue;
import ic.doc.catalogues.Searchable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookSearchQueryTest {

    @Test
    public void allowsLookingUpBooksByAuthor() {

        // Create a smaller searchable catalogue
        Searchable catalogue = new Searchable() {
            @Override
            public List<Book> searchFor(String author) {
                return new ArrayList<Book>(Arrays.asList(
                        new Book("A Tale of Two Cities", "Dickens"),
                        new Book("Pride and Prejudice", "Austen"),
                        new Book("Pride and Prejudice", "Austen")));
            }
        };

        List<Book> books = new BookSearchQuery("dickens", catalogue).execute();
        assertThat(books.size(), is(greaterThan(0)));
        for (Book book : books) {
            assertTrue(book.isWrittenBy("dickens"));
        }

    }

}
