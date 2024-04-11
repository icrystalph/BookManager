import ecs100.*;
/**
 * support class for book
 *
 * @author (CS)
 * @version (10/04/24)
 */
public class Book
{
    // instance variables
    private String title;
    private String author;
    private int likes;
    
    // code for book cover (image)
    private String image;
    private static final String DEFAULT_IMAGE = "book.png";


    /**
     * Constructor for objects of class Book
     */
    public Book(String name, String writer, int qty, String img)
    {
        // initialise instance variables
        title = name;
        author = writer;
        likes = qty;
        
        // add a default image if user clicks cancel
        if (img == null) {
            //if user clicks cancel it sets default img
            image = DEFAULT_IMAGE;
        } else{
            image = img;
        }
    }

    /**
     * Overload constructor if there is no img parameter
     * 
     */
    public Book(String name, String writer, int qty)
    {
        // Call the other constructor 
        // will execute method depending on how many parameters
        this(name, writer, qty, DEFAULT_IMAGE);
        
    }
    
    /**
     * Display image on GUI
     */
    
    public void displayBook() {
        int locX = 100;
        int locY = 100;
        final double WIDTH = 100; 
        final double HEIGHT = 100;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    /**
     * Create getter and/or setter methods here as necessary
     */
}
