import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThamanSuggala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThamanSuggala extends Student
{
    public String wave1File;
    public String wave2File;
    public String hatOnFile;
    public String hatOffFile;
    /**
     * Constructor for the KilgoreTrout class.
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
    public ThamanSuggala(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        
        wave1File=firstName.toLowerCase()+ lastName.toLowerCase()+"_wave1.jpg";
        wave2File=firstName.toLowerCase()+ lastName.toLowerCase()+"_wave2.jpg";
        
        hatOnFile=firstName.toLowerCase()+ lastName.toLowerCase()+"_tophat.jpg";
        hatOffFile=firstName.toLowerCase()+ lastName.toLowerCase()+"_hatoff.jpg";
        
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public ThamanSuggala() {
        firstName="Thaman";
        lastName="Suggala";
        mySeatX=2;
        mySeatY=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        //standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        wave1File=firstName.toLowerCase()+ lastName.toLowerCase()+"_wave1.jpg";
        wave2File=firstName.toLowerCase()+ lastName.toLowerCase()+"_wave2.jpg";
        hatOnFile=firstName.toLowerCase()+ lastName.toLowerCase()+"_tophat.jpg";
        hatOffFile=firstName.toLowerCase()+ lastName.toLowerCase()+"_hatoff.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                //setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to run and meet new people!!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                specialAction();  // Thaman Suggala's special method
           
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
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void specialAction(){
        /*setLocation(0,0);
         Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(10);
        }   
           Greenfoot.delay(20);
           returnToSeat();
    */
    GreenfootImage wave1 = new GreenfootImage(wave1File);
    GreenfootImage wave2 = new GreenfootImage(wave2File);
    
    GreenfootImage hatOn = new GreenfootImage(hatOnFile);
    GreenfootImage hatOff = new GreenfootImage(hatOffFile);
    for (int i=1; i <= 30; i++){
        wave1.scale(15, 15);
        wave2.scale(15, 15);
        Greenfoot.delay(10);
        if (i <= 15) {
            if (i % 2 == 0){
                setImage(wave1File);
                Greenfoot.delay(20);
            } else {
                setImage(wave2File);  
                Greenfoot.delay(20);
            }
            
        } else if (i <= 25){
            if (i % 2 == 0){
                setImage(hatOff);
                Greenfoot.delay(20);
            } else {
                setImage(hatOn);
                Greenfoot.delay(20);
            }
        }else {
            setImage(portraitFile);
            Greenfoot.delay(10);
        }
    }
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
