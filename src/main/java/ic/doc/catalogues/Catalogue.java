package ic.doc.catalogues;

import ic.doc.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class allows new catalogues to be created with minimal duplication
 */

public abstract class Catalogue implements Searchable {

    private final Collection<Book> catalogue = allTheBooks();

    public List<Book> searchFor(String author) {

        List<Book> results = new ArrayList<>();
        for (Book book : catalogue) {
            if (book.isWrittenBy(author)) {
                results.add(book);
            }
        }
        return results;
    }

    protected abstract Collection<Book> allTheBooks();

}
