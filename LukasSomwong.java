import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The LukasSomwong class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class LukasSomwong extends Student implements SpecialInterestOrHobby
{
    private String handFile;
    private String macFile;
    private String robotFile;
    /**
     * Constructor for the LukasSomwong class.
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
    public LukasSomwong(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        handFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-pointing.png";
        macFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-macbook.png";
        robotFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-robot.png";
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public LukasSomwong() {
        firstName="Lukas";
        lastName="Somwong";
        mySeatX=1;
        mySeatY=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
       handFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-pointing.png";
        macFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-macbook.png";
        robotFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-robot.png";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the LukasSomwong actor wants to do. This method is called whenever
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
                sayName(soundFile);
            
                myHobby("I like to program robots!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                codingAnimation();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
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
     * This is a local method specific to the LukasSomwong class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void codingAnimation(){
        World world=getWorld();
    
        //setLocation(0,0);
        //Greenfoot.delay(10);
        
        LukasSomwongProp macBook = new LukasSomwongProp();
        macBook.setImage(macFile);
        macBook.setRotation(-20); 
        world.addObject(macBook, 3, 7);        
        
        LukasSomwongProp pointingHand = new LukasSomwongProp();
        pointingHand.setImage(handFile);
        pointingHand.setRotation(-10); 
        world.addObject(pointingHand, 4, 8);
        
        LukasSomwongProp pointingHand2 = new LukasSomwongProp();
        pointingHand2.setImage(handFile);
        pointingHand2.setRotation(-10); 
        world.addObject(pointingHand2, 4, 7);  
        
        LukasSomwongProp robot = new LukasSomwongProp();
        robot.setImage(robotFile);
        world.addObject(robot, 2, 10);    
        
        setRotation(-15);
        

        
        // Rotate hands
        for (int i=1;i<=6;i++) {
            pointingHand.setRotation(10);
            pointingHand2.setRotation(-15);
            Greenfoot.delay(10);
            pointingHand.setRotation(-15);
            pointingHand2.setRotation(10);
            Greenfoot.delay(10);
        }
        
        world.removeObject(pointingHand);
        world.removeObject(pointingHand2);
        world.removeObject(macBook);
        
        setLocation(1,7);
        setRotation(0);
        
        for (int i=1;i<=10;i++) {
            robot.setLocation(robot.getX()+1, robot.getY());
            setLocation(getX()+1, getY());
            Greenfoot.delay(2);
        }
        
        
        for (int i=1;i<=5;i++) {
            robot.setLocation(robot.getX(), robot.getY()-1);
            setLocation(getX(), getY()-1);
            Greenfoot.delay(2);
        }
        
        for (int i=1;i<=10;i++) {
            robot.setLocation(robot.getX()-1, robot.getY());
            setLocation(getX()-1, getY());
            Greenfoot.delay(2);
        }
        
            

       Greenfoot.delay(20);
       
       world.removeObject(robot);
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
