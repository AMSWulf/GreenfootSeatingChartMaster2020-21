import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlyingObjects extends Actor
{
    /**
     * Act - do whatever the FallingObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int airSpeed = 1;
    private boolean onBottom = false;
    public void act()
    {
        // Add your action code here.
        fly();
    }
    public void fly(){
        if(!onBottom){
            this.setLocation(getX()+airSpeed,getY());
            onBottom=CheckBottom();
        }
        if(onBottom){
            getWorld().removeObject(this);
        }
    }
    public boolean CheckBottom(){
        if(getX()>14){
            return true;
        }
        else{
            return false;
        }
    }
}
