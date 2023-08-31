import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The WilliamHan class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class WilliamHan extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the WilliamHan class.
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
    public WilliamHan(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public WilliamHan() {
        firstName="William";
        lastName="Han";
        mySeatX=2;
        mySeatY=7;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the WilliamHan actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    boolean c = false;
    GreenfootImage sleeping = new GreenfootImage("williamhanSleeping.jpg");
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                //sitting=false;
                //setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                //sayName(soundFile);
            
                myHobby("I like to sleep!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
                //Sleep();
                c = true;
                setImage(sleeping);
                returnToSeat();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
                timeStamp = System.currentTimeMillis();
                sitDown();
                sayName(soundFile);
            }
        if (c){
            Sleep();
        }
    } 
    
    long timeStamp = System.currentTimeMillis();
    long currentTime;
    double growMod = 1;
    boolean filp = false;
    private void Sleep(){
        if (Greenfoot.getRandomNumber(70) == 1){
        getWorld().addObject(new Z(),getX(),getY());
        }
        //System.out.println("sleeping");
        //System.out.println(growMod);
        setImage(sleeping);
        GreenfootImage image = getImage();
        currentTime = System.currentTimeMillis();
        if (currentTime >= timeStamp + 15000){
            c = false;
            setImage("williamhan.jpg");
        }
       // image.scale(100000,10000);
            currentTime = System.currentTimeMillis();
            if (image.getWidth() + (int)growMod > 0){
                image.scale(image.getWidth() + (int)growMod, image.getHeight() + (int)growMod);
            } else {
                image.scale(1,1);
            }
            if (filp != true){
                //growMod += Greenfoot.getRandomNumber(2);
                growMod += 0.02;
                if (image.getWidth() > 70) {
                    growMod = 0;
                    filp = true;
                }
            } else {
                //growMod -= Greenfoot.getRandomNumber(2);
                growMod -= 0.02;
                if (image.getWidth() < 60) {
                filp = false;
                growMod = 0; 
            }}
    }
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
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
