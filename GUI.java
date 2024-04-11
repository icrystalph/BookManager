import ecs100.*;
/**
 * Handles the GUI 
 *
 * @author (CS)
 * @version (11/04/24)
 */
public class GUI
{
    // instance variables 
    private books books; // declare the books instance that holds the collection 

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new books(); // instantiate the books class
        UI.initialise();
        UI.addButton("Add", this::addBook);
        UI.addButton("Remove", this::removeBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Quit", UI::quit);
        
    }

    /**
     * Add book to collection 
     *
     * 
     */
    public void addBook() {
        // Ask user for details
        String name = UI.askString("Title:"); // Error check duplicates here?
        String author = UI.askString("Author:");
        
        // for higher grades this would need boundary/error checking (if statement dont allow million. Use constants. Prevent - numbers
        int likes = UI.askInt("Likes:");
        
        // add a book image
        String imgFileName = UIFileChooser.open("Choose image file");
        
        // add book the the hashmap
        //access method from other class
        books.addBook(name, author, likes, imgFileName);
    }
    
    /**
     * Removes book based on name
     */
    
    public void removeBook(){
        //ask user what book to remove
        String bookName = UI.askString("What book do you want to remove:");
        if (books.removeBook(bookName)){
            UI.println("book Was removed.");
            
        }else{
            UI.println("Book doesnt exist");
            
        }
        
        
    
    }
    
    /**
     * Finds book based on name
     */
    public void findBook() {
        // Ask user for title 
        /**
         * For E I'd be looking that you sanitised the title (capitals).
         * Check book doesnt already exist
         * Click on image to like it 
         */
        String bookName = UI.askString("Name of book:");
        
        // look for book in hashmap
        //if method returns true, this code is executed
        if (books.findBook(bookName)) {
            UI.println("Found book!");
            // print out the detials of the book (on the text pane)
            
        //if method returns false, this code is executed
        }else {
            UI.println("Book doesnt exist");
        }
            
        }
    }

