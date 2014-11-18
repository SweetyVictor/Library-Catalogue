package ic.doc.catalogues;

import ic.doc.Book;

import java.util.List;

/**
 * Created by danesherburn on 18/11/14.
 */
public interface Searchable {

    List<Book> searchFor(String author);

}
