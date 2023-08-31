import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Z here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Z extends Actor
{
    /**
     * Act - do whatever the Z wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image =getImage();
    int c = 0;
    private void prepare(){
        image.scale(50,50);   
    }
    public void act()
    {
        //System.out.println(System.currentTimeMillis() % 500);
        if (System.currentTimeMillis() % 500 < 20){
            c++;
         setLocation(getX() + Greenfoot.getRandomNumber(3)-2, getY()- 1);   
        }
        if (c > 5){
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }
}
