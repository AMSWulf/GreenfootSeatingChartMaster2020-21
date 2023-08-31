import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Rohan's class representing his seat and animation in Mr. Kaehms' 3rd period CSA.
 * 
 * @author Rohan Vij
 * @version 1.0 Aug 29, 2023
 */
public class RohanVij extends Student implements SpecialInterestOrHobby
{

    GreenfootImage standingImage; // Stores standingImage variable to be used and resized throughout the program
    private ArrayList<Actor> stars = new ArrayList<>(); // Stores star actors to be wiped every time the screen refreshes
    /**
     * Constructor for the RohanVij class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public RohanVij(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        
        standingImage = new GreenfootImage(standingFile);
        standingImage.scale(standingImage.getWidth()/10, standingImage.getHeight()/10);
    
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public RohanVij() {
        firstName="Rohan";
        lastName="Vij";
        mySeatX=9;
        mySeatY=9;
        
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        
        standingImage = new GreenfootImage(standingFile);
        standingImage.scale(standingImage.getWidth()/10, standingImage.getHeight()/10);
        
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the RohanVij actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
                sitting=false;
                
                // Changing image to standing image
                setImage(standingImage);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to play Kerbal Space Program and keep up with space news!");
            
                
                paleBlueDot();
           
                sitDown();
            }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */

   
    /**
     * This is a local method specific to the RohanVij class used to animate the character once the image is clicked on.
     * Make the standing picture move to the middle of the class before changing the setting to space.
     * Stars display for a couple iterations before a blue dot representing the "pale blue dot" is shown in conjunction
     * with a quote from Carl Sagan -
     * “Look again at that dot. That's here. That's home. That's us. On it everyone you love, everyone you know,
     * everyone you ever heard of, every human being who ever was, lived out their lives.”
     */
    public void paleBlueDot() {
        setLocation(getWorld().getWidth() / 2, 20);
        
        int initialY = getY();
        int middleY = (getWorld().getHeight() / 2) - 5;
        
        System.out.println(middleY);
    
        for (int y = initialY; y > middleY; y--) {
            setLocation(getX(), y);
            Greenfoot.delay(20);
        }
    
    
        // Set the background to black
        GreenfootImage blackBackground = new GreenfootImage(getWorld().getWidth(), getWorld().getHeight());
        blackBackground.setColor(Color.BLACK);
        blackBackground.fill();
        getWorld().setBackground(blackBackground);
        
        // Move to middle of screen
        setLocation(getWorld().getWidth() / 2, 6);
        
        // Remove all actors that are not the current actor
        for (Object obj : getWorld().getObjects(Actor.class)) {
            Actor actor = (Actor) obj;
            if (actor != this) {
                getWorld().removeObject(actor);
            }
        }
        
        // Write Space text
        GreenfootImage textImage = new GreenfootImage("Pale Blue Dot (Earth)", 52, Color.WHITE, new Color(0, 0, 0, 0));
        getWorld().getBackground().drawImage(textImage, 7, 2);
        
        // Increase standing img size
        standingImage.scale(standingImage.getWidth()*2, standingImage.getHeight()*2);
        
        // Make stars
        for (int i = 0; i < 5; i++) {
            createStars(50);
            Greenfoot.delay(50);
        }
        
         // Add a small blue dot
        GreenfootImage dotImage = new GreenfootImage(20, 20);
        dotImage.setColor(Color.BLUE);
        dotImage.fillOval(0, 0, 20, 20);
        Actor blueDot = new Actor() {};
        blueDot.setImage(dotImage);
        getWorld().addObject(blueDot, 6, 3);
        
        // Display the quote near the blue dot
        String quoteText = "“Look again at that dot. That's here. That's home. That's us. On it everyone you love, everyone you know, \neveryone you ever heard of, every human being who ever was, lived out their lives.” - Carl Sagan, Pale Blue Dot";
        GreenfootImage quoteImage = new GreenfootImage(quoteText, 16, Color.WHITE, new Color(0, 0, 0, 0));
        getWorld().getBackground().drawImage(quoteImage, 70, 150);
        
        
        Greenfoot.delay(500);
        
        sitDown();
        
        // Resetting world after finishing code; too hard to clear all text, etc
        Greenfoot.setWorld(new Classroom());
    }
    
    /*
     * Function to create stars on the screen.
     * Removes existing stars from the previous iteration every time it runs.
     */
    private void createStars(int numberOfStars) {
        
        for (Actor star : stars) {
            getWorld().removeObject(star);
        }
        
        // Clear the list of stars
        stars.clear();
        
        for (int i = 0; i < numberOfStars; i++) {
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            System.out.println(x);
            int y = Greenfoot.getRandomNumber(getWorld().getHeight());
            
            // Randomly select star color (yellow or white)
            Color starColor = (Greenfoot.getRandomNumber(2) == 0) ? Color.YELLOW : Color.WHITE;
            
            // Draw the star
            GreenfootImage starImage = new GreenfootImage(5, 5);
            starImage.setColor(starColor);
            starImage.fillOval(0, 0, 5, 5);
            
            // Create a new star actor and add it to the world
            Actor star = new Actor() {};
            star.setImage(starImage);
            getWorld().addObject(star, x, y);
            
            stars.add(star);
        }
    }
    
    

     /**
     * Using the hobby interface to print out my space-related hobbies!
     */
     public void myHobby(String s) {
         System.out.println(s);
}

}