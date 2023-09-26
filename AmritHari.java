 import greenfoot.*; 

 public class AmritHari extends Student implements SpecialInterestOrHobby
 {
     public AmritHari(String f, String l, int r, int s) {
         firstName = f;
         lastName = l;
         mySeatX = r;
         mySeatY = s;
         portraitFile = f.toLowerCase()+ l.toLowerCase()+ ".jpg";
         standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
         soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
         setImage(portraitFile);
         sitting=true;
     }
     public AmritHari() {
         firstName = "Amrit";
         lastName = "Hari";
         mySeatX = 1;
         mySeatY = 1;
         portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
         standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
         soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
         setImage(portraitFile);
         sitting=true;
     }
     public void act() 
     {
         if(Greenfoot.mouseClicked(this)){
             sitting=false;
             setImage(standingFile);
             System.out.println("");
             getName();
             sayName(soundFile);
             myHobby("I like to read");
             diagonalMovement();  
             sitDown();
            }
        
    }
     public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
public void diagonalMovement() {
    setLocation(0, 0);
    Greenfoot.delay(10);

    for (int i = 1; i <= 9; i++) {
        setLocation(i, i);
        Greenfoot.delay(10);
    }

    for (int i = 9; i >= 0; i--) {
        setLocation(i, 5 - i);
        Greenfoot.delay(10);
    }

    Greenfoot.delay(20);
    returnToSeat();
}
     public void myHobby(String s) {
         System.out.println(s);
}


     
 }
