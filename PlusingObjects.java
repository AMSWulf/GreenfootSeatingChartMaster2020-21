import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlusingObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlusingObjects extends Actor
{
    /**
     * Act - do whatever the PlusingObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean filp = false;
    long currentTime;
    private boolean Sleep(double growMod, long startTime){
        if (Greenfoot.getRandomNumber(70) == 1){
        getWorld().addObject(new Z(),getX(),getY());
        }
        //System.out.println("sleeping");
        //System.out.println(growMod);
        GreenfootImage image = getImage();
        currentTime = System.currentTimeMillis();
        if (currentTime >= startTime + 15000){
            return false;
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
            }
        }
        return true;
    }
}
