import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * 
 * This is a container for methods that could be called from the Classroom.  Possible methods could include the following:
 * public void assignSeatsToDeskGroups();  // iterates through all seats and sets the deskGroup based on position of each seat
 * public void getCurrentStudents(int deskGroup)  // list all students in a current deskGroup  (prints to console)
 * Can you think of others?
 * 
 * methods should be public, so they can be called when the scenario is in pause mode.
 * 
 * @author (your name (add your groups names here, and tie to any method that you add) 
 * @version (a version number or a date. Update this for each revision)
 */
public class StudentDeskGroup extends Actor
{
    /**
     * Act - do whatever the StudentDeskGroup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Variable needed for Assigning Seats to Desk Groups
    public static int[][][] seatDesks = new int[8][4][2];
    // Variable needed for Assigning Seats to Desk Groups
    public static ArrayList<List<Integer>> baseCoords = new ArrayList<List<Integer>>();
    
    public void act() 
    {
        // Add your action code here.
    }
    
    
    /**
     * Gets and prints all student names in a given table group. 
     * The method is called in the Classroom.java file
     * 
     * Created by: Sajeev Magesh, Pingyao Liu, Sid Shastri, Aarush
     */
    public static void getCurrentStudents(List<Student> students, int deskGroup){
        ArrayList<String> studentNames = new ArrayList<String>();
        for (Student stud:students){
            for (int i=0;i<4;i++){
                if (stud.getX()==seatDesks[deskGroup-1][i][0] && stud.getY()==seatDesks[deskGroup-1][i][1]){
                    System.out.println(stud.getFirstName() + " " + stud.getLastName() + " Is a student in table group: " + deskGroup);
                }
            }
            
        }
        
    }
    
    /**
     * Method assigns seat coordinates to their respective table numbers and stores them in a 3d array
     * This is called in the Classroom.java file
     * 
     * Created by: Sajeev Magesh, Pingyao Liu, Sid Shastri, Aarush Shetty
     */
    public static void assignSeatsToDeskGroups(){
        baseCoords.add(Arrays.asList(5,9)); //table 1
        baseCoords.add(Arrays.asList(8,9)); //table 2
        baseCoords.add(Arrays.asList(8,6)); //table 3
        baseCoords.add(Arrays.asList(5,6)); //table 4
        baseCoords.add(Arrays.asList(2,6)); //table 5
        baseCoords.add(Arrays.asList(2,3)); //table 6
        baseCoords.add(Arrays.asList(5,3)); //table 7
        baseCoords.add(Arrays.asList(8,3)); //table 8
        for (int i=0;i<8;i++){
            for (int j=0;j<4;j++){
                if (j==0){
                    seatDesks[i][j][0]= baseCoords.get(i).get(0);
                    seatDesks[i][j][1]= baseCoords.get(i).get(1);
                }
                else if (j==1){
                    seatDesks[i][j][0]= baseCoords.get(i).get(0)+1;
                    seatDesks[i][j][1]= baseCoords.get(i).get(1);
                }
                else if (j==2){
                    seatDesks[i][j][0]= baseCoords.get(i).get(0);
                    seatDesks[i][j][1]= baseCoords.get(i).get(1)+1;
                }
                else if (j==3){
                    seatDesks[i][j][0]= baseCoords.get(i).get(0)+1;
                    seatDesks[i][j][1]= baseCoords.get(i).get(1)+1;
                }
            }
        }
    }
}

