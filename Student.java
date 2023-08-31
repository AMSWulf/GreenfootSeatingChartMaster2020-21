import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Student extends Actor
{
   //Instance variables
   public String firstName;
   public String lastName;
   public int mySeatX;         // rows start in the front of class (1), and end in the back of class
   public int mySeatY;        // seats are left to right, 1-8
   public boolean isActive;  // can you think of an algorithm that would allow you to use this
                             // variable to use keyboard entry for all the instance of a student
                             // that we will create?
   public boolean sitting;   // Is the student sitting or standing (default sitting)                         
   
 //  public String imgFile;   // These will be created in subclass as firstName.toLowerCase()+
   public String portraitFile; // image used when sitting
   public String standingFile; // image used when standing
   public String soundFile; //      firstName.toLowerCase()+lastName.toLowerCase()+".ext"; (.wav or .jpg)
   public String pianoFile; // image for student playing piano 
   Classroom clas = (Classroom) getWorld();
   public void setSeatX(int r){
       mySeatX=r;
    }
    
    public void setSeatY(int s){
       mySeatY=s;
    }
    
    public abstract void  getName(); //This is an abstract methods. You will have to implement it
                                 // in your own class file. See KilgoreTrout for an example
     /**
     * 
     * Will temporarily swap the desk seating position of two Student instances and will move them there
     * 
     * DOES NOT change the "mySeatX" and "mySeatY" instance variables, so ".sitdown()" CAN be used to return to original seats
     * 
     * @author Nakul Soneji, Krisha Soneji, Harmandeep Sandhu, Ashmit Sethi
     * @param other a student object that you wish to switch seats with
     */               
     public void tempSwapSeats(Student other) {
         int tempX = this.GetSeatX();
         int tempY = this.GetSeatY();
         this.setLocation(other.GetSeatX(), other.GetSeatY());
         other.setLocation(tempX, tempY);
     }
     /**
     * 
     * Will permanently swap the desk seating position of two Student instances and will move them there
     * 
     * DOES change the "mySeatX" and "mySeatY" instance variables, so ".sitdown()" CANNOT be used to return to original seats
     * 
     * @author Nakul Soneji, Krisha Soneji, Harmandeep Sandhu, Ashmit Sethi
     * @param other a student object that you wish to switch seats with
     */               
     public void swapSeats(Student other) {
         int tempX = this.GetSeatX();
         int tempY = this.GetSeatY();
         
         this.mySeatX = other.GetSeatX();
         this.mySeatY = other.GetSeatY();
         other.mySeatX = tempX;
         other.mySeatY = tempY;
         
         this.sitDown();
         other.sitDown();
     }
    /**
     * Plays a sound file when called
     * @param String myNameFile  is the name of the sound file to play, ex "mySound.wav",
     */
    
    public int GetSeatX(){
        return mySeatX;
    }
    
    public int GetSeatY(){
        return mySeatY;
    }
    public String getFirstName(){
        return firstName;
    }
     public String getLastName(){
        return lastName;
    }
    
    public void sayName(String myNameFile){
        Greenfoot.playSound(myNameFile);
    }
    
    public void returnToSeat(){
        setLocation(mySeatX,mySeatY);
    }
    public void sitDown(){
        returnToSeat();
        setImage(portraitFile);
        sitting=true;
    }
    public void assignSeat(){
        mySeatX=getX();
        mySeatY=getY();
    }
    public void getTablemateHobbies(int tableGroupNumber) {
        if (tableGroupNumber == 7) {
            setLocation(mySeatX + 1, mySeatY); 
            Greenfoot.delay(100);
            System.out.println(this.getFirstName());
        }
    }
}
