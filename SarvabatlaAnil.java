import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Anil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SarvabatlaAnil extends Student
{
    /**
     * Act - do whatever the Anil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            getName();
            myHobby();
            World world;
            world = getWorld();
            world.addObject(new plane(),1,1);        
            world.addObject(new F16(),1,3);        
            world.addObject(new Sukhoisu35(),1,7);        
            world.addObject(new Emirates(),1,11);           
    }
        }
    public void getName(){
        System.out.println("My name is " + "Anil" + " " + "Sarvabatla");
    }
    public void myHobby(){
        System.out.println("My hobby is playing video games and coding");
    }
}
