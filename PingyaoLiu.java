import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PingyaoLiu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
    /**aimport greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PingyaoLiu class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class PingyaoLiu extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the PingyaoLiu class.
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
    public PingyaoLiu(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        pianoFile=f.toLowerCase()+ l.toLowerCase()+"-playpiano.png"; 
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public PingyaoLiu() {
        firstName="Pingyao";
        lastName="Liu";
        mySeatX=4;
        mySeatY=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.png";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        pianoFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-playpiano.png"; 
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the PingyaoLiu actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                //sayName(soundFile);
                
                myHobby("I like to play piano and violin and learn languages! ");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                playPiano();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
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
     * This method needs to allow th
     * e user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */

   
    /**
     * This is a local method specific to the PingyaoLiu class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void playPiano(){
        setLocation(6,2);
        Greenfoot.delay(10);
        // move up
        for (int i=1;i<2;i++){
            setLocation(6,3-i); // this will end at (6, 2)  
            Greenfoot.delay(50);
        }
        // move right 
        for (int i=6;i<12;i++){
            setLocation(i,1); // this will end at (11, 4) 
            Greenfoot.delay(50);
        }
        setImage(pianoFile);
        Greenfoot.delay(100);
        setImage(standingFile);
        // move right 
        for (int i=1;i<6;i++){
            setLocation(11-i,1);
            Greenfoot.delay(50);
        }
        
        for (int i=1;i<2;i++){
            setLocation(6,1+i);
            Greenfoot.delay(50);
        }
        
        returnToSeat();
    }
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s);
}

}