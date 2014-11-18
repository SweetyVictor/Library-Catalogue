package ic.doc.catalogues;

import ic.doc.Book;
import java.util.Arrays;
import java.util.Collection;

public class BritishLibraryCatalogue extends Catalogue {

    // imagine that each new instance of this object uses more than 500MB of RAM

    private static BritishLibraryCatalogue britishLibraryCatalogue = null;

    private BritishLibraryCatalogue() {}

    public static synchronized BritishLibraryCatalogue getInstance() {

        // lazy initialisation

        if (britishLibraryCatalogue == null) {
            britishLibraryCatalogue = new BritishLibraryCatalogue();
        }

        return britishLibraryCatalogue;
    }

    protected Collection<Book> allTheBooks() {
        return Arrays.asList(
            new Book("A Tale of Two Cities", "Dickens"),
            new Book("Pride and Prejudice", "Austen"),
            new Book("Pride and Prejudice", "Austen"),
            new Book("The Picture of Dorian Gray", "Wilde"),
            new Book("Oliver Twist", "Dickens"),
            new Book("Frankenstein", "Shelley"),
            new Book("Brave New World", "Huxley"),
            new Book("Lord of the Flies", "Golding"),
            new Book("Hamlet", "Shakespeare"),
            new Book("The Life and Opinions of Tristram Shandy, Gentleman", "Sterne"));

            // and so on... Imagine that this list is very large and therefore uses a lot of memory.
    }

}
