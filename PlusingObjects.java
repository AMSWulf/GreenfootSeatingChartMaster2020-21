import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//Made by william, manning, trey, and sajeevmagesh


/**
 * Write a description of class PlusingObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//Accpets a double and long as inputs, first being how fast it grows and shrinks, while the other is the start time when you called this method(use Greenfoot.SystemtimeMillis in there)
public class PlusingObjects extends Actor
{
    /**
     * Act - do whatever the PlusingObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean filp = false; //wheather it is growing or shrinking
    long currentTime;
    private boolean Sleep(double growMod, long startTime){
        if (Greenfoot.getRandomNumber(70) == 1){
        getWorld().addObject(new Z(),getX(),getY());
        }
        //System.out.println("sleeping");
        //System.out.println(growMod);
        GreenfootImage image = getImage();
        currentTime = System.currentTimeMillis(); // counting weather if current time is over 15 seconds
        if (currentTime >= startTime + 15000){
            return false;
        }
       // image.scale(100000,10000);
            currentTime = System.currentTimeMillis();
        if (image.getWidth() + (int)growMod > 0){ // checks if the new image will be to small for green foot
            image.scale(image.getWidth() + (int)growMod, image.getHeight() + (int)growMod);
        } else {
            image.scale(1,1);
        }
        
        if (filp != true){ //adds if its growing and shrinks if it's not
            //growMod += Greenfoot.getRandomNumber(2);
            growMod += 0.02;
        
            if (image.getWidth() > 70) { // the upper bound of growth
                growMod = 0;
                filp = true;
            }
            } else {
                //growMod -= Greenfoot.getRandomNumber(2);
                growMod -= 0.02;
                if (image.getWidth() < 60) { //the lower bound of growth
                filp = false;
                growMod = 0; 
            }
        }
        return true;
    }
}
