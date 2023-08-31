import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Manning Wu, Mr Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 * @version 4.0 Aug 22, 2023
 */
public class ManningWu extends Student implements SpecialInterestOrHobby
{

    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public ManningWu() {
        firstName="Manning";
        lastName="Wu";
        mySeatX=2;
        mySeatY=7;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the ManningWu actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
                sitting=false;
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
                myHobby("I love biking!");
                bikemountain_manning();
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
     * Local method to ManningWu class used to animate the character biking up and down a mountain 
     * once the image is clicked on.
     */
    public void bikemountain_manning(){
        setLocation(6,6);
        Greenfoot.delay(10); 
        
        String[] mountain_biking = {"mountain_biking1.png", "mountain_biking2.png", "mountain_biking3.png",
            "mountain_biking4.png", "mountain_biking5.png", "mountain_biking6.png", "mountain_biking7.png"};
        for(int i = 0; i < 7; i++){
            setImage(mountain_biking[i]);
            Greenfoot.delay(15);
        } 
        Greenfoot.delay(20);
        returnToSeat();
    }
     /**
     * myHobby is one of the interfaces provided.  
     */
     public void myHobby(String s) {
         System.out.println(s);
}

}