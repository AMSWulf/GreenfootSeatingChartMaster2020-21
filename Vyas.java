import greenfoot.*;

public class Vyas extends Student 
{
    private int binaryDropTimer = 0; // Timer for dropping binaries
    private int binaryDropInterval = 100; // Time interval for dropping binaries
    private boolean jumpscareVisible = false;
    private int jumpscareDuration = 480; // 6 seconds at 60 frames per second

    public Vyas(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        mySeatX = r;
        mySeatY = s;
        portraitFile = "Springtrapicon.jpg";
        soundFile = "fnafjumpscare.mp3";
        setImage(portraitFile);
        sitting = true;
        setLocation(mySeatX, mySeatY);
        returnToSeat();
    }

    public Vyas() {
        mySeatX = 2;
        mySeatY = 1;
        portraitFile = "Springtrapicon.jpg";
        soundFile = "fnafjumpscare.mp3";
        setImage(portraitFile);
        sitting = true;
        setLocation(mySeatX, mySeatY);
        returnToSeat();
    }

    public void act() {
        super.act(); // Call the parent's act method

        if (Greenfoot.mouseClicked(this)) {
            sitting = false;
            sayName(soundFile);

            // Show the jumpscare image
            GifImage myGif = new GifImage("jumpscare2.gif");
            setImage(myGif.getCurrentImage());
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2); // Center the image
            jumpscareVisible = true;
            jumpscareDuration = 480; // Reset the jumpscare duration
        }

        // Check if the jumpscare is visible
        if (jumpscareVisible) {
            jumpscareDuration--;

            // Check if the jumpscare duration has reached 0
            if (jumpscareDuration <= 0) {
                // Hide the jumpscare image
                setImage(portraitFile);
                setLocation(mySeatX, mySeatY); // Reset the location
                jumpscareVisible = false;
            }
        }
    }

    public void getName() {
        System.out.println("Hello, my name is Tactical Droid");
    }
}
