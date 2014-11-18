package ic.doc;

import ic.doc.catalogues.Searchable;
import java.util.List;

public class BookSearchQuery {

    private final String author;
    private final Searchable catalogue;

    public BookSearchQuery(String author, Searchable catalogue) {
        this.author = author;
        this.catalogue = catalogue;
    }

    public List<Book> execute() {

        return catalogue.searchFor(author);

    }
}