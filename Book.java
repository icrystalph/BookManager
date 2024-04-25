import ecs100.*;
import java.util.HashMap;
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
    public int likes;
    private int locX = 100;
    private int locY = 100;
    final double WIDTH = 100; 
    final double HEIGHT = 100;
    
    // code for book cover (image)
    private String image;
    private static final String DEFAULT_IMAGE = "book.png";
    private boolean coverClicked = false;


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
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    /**
     * Edit likes via click
     */
    //here, we have a method that does the maths for calculating whether the click 
    //is within one of the covers or not. So you'd do the 'if x> left & x < right return bulb tru
    // it will also change onCover boolean variable to true or false. This will then
    //allow the methods in the GUI to function (doMouse) so if the boolean here returns
    //a 'true' value it willl trigger the code in doMouse method GUI to work. If its false nothing happens
    
    public boolean onCover(double x, double y) {
        if ((x >= locX) && (x <= locX + WIDTH) &&
        (y >= locY) && (y <= locY + HEIGHT)){
            coverClicked = true;
        }else{
            coverClicked = false;
        }
        return coverClicked;
    }
    
    /**
     * Adds a like everytime user clicks
     */
    // this method is called from doMouse in GUI and adds a like evrytime user likes it
    //prints number of likes
    public void addLike() {
        likes++;
        UI.println(likes);
    }
    
    
    /**
     * Create getter and/or setter methods here as necessary
     */
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getImage(){
        return image;
    }
    
    public int getLocX(){
        return locX;
    }
    
    public void setLocX(int locX){
        this.locX = locX;
    }
    
}
