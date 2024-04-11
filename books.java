import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap
 * allows user to add find print edit delete
 * Should check to prevent adding duplicates 
 *
 * @author (CS)
 * @version (11/04/24)
 */
public class books
{
    // instance variables - replace the example below with your own
    private HashMap<String, Book> library; //declaring the hashmap
    private Book currBook; //store the instance of the current book

    /**
     * Constructor for objects of class books
     */
    public books()
    {
        library = new HashMap<String, Book>(); //initialise hashmap
        
        // Create books - sample data
        Book b1 = new Book("The Narrow Corridor", "James A. Robinson", 10);
        library.put("The Narrow Corridor", b1);
        
        // Same as above but no variable (faster)
        library.put("Hairy Mclary", new Book("Hairy Mclary", "Margaret Mahey", 1000));
        library.put("Dune", new Book("Dune", "Fenak Herbert", 50));
    }
    
    /**
     * Add a book to the HashMap
     */
    
    public void addBook(String name, String author, int likes, String img){
        library.put(name, new Book(name, author, likes, img));
    }
    
    /**
     * Remove a book from hashmap
     */
    public boolean removeBook(String name) {
        // check if book is in hashmap
        for (String bookName : library.keySet()) {
            if (bookName.equals(name)) { // if book key is found
                library.remove(bookName);
                return true;
            }
        }
        return false;
    }

            
    /**
     * Finds book based on name
     * Set current book if found
     */
    public boolean findBook(String name) {
        // search for book in hashmap
        for (String bookName : library.keySet()) {
            if (bookName.equals(name)) { // if book key is found
                currBook = library.get(bookName); // set current Book
                // show book
                currBook.displayBook();
                return true;
            }
        }
        return false;
    }
}

    