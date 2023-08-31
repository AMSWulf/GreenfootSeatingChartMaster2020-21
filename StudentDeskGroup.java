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
     * Introduces each student for the table group & makes them stand
     * The method is called in the Classroom.java file
     * Table method for table group 3
     * 
     * @author Anwesha
     * @author Ria
     * @author Jasmine
     * @author Lokesh
     * 
     * @version 1.0 August 30, 2023
     * 
     * @param List<Student> table Students - holds 4 Student objects of students at the table
     * @param int tableNum - the table number of the table group
     */
    
    public static void meetTable(List<Student> students, int tableNum) {
        
        System.out.println("Hello! We are table group number " + tableNum + ".");
        
        List<Student> tableStudents = new LinkedList<Student>();
        /** 
         * first for loop below is from getCurrentStudents
         * credit to : Sajeev Magesh, Pingyao Liu, Sid Shastri, Aarush
         */
        //first for loop
        //get students of table
        for (Student student : students){
            for (int i=0;i<4;i++){
                if (student.getX()==seatDesks[tableNum-1][i][0] && student.getY()==seatDesks[tableNum-1][i][1]){
                    tableStudents.add(student);
                }
            }  
        }
        
        // introduce and stand for loop
        for (Student student : tableStudents){
            String first = student.getFirstName();
            String last = student.getLastName();
            System.out.println("I am " + first + " " + last + ".");
            String standingFile = first.toLowerCase() + last.toLowerCase() + "-standing.jpg";
            student.setImage(standingFile);
            Greenfoot.delay(20);
        }
        
        //return to sitting
        for (Student student : students) {
            student.sitDown();
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

