/**
 *      Class: StudentAssignments
 *      @author: Evan Sellers
 *      Purpose: Create an assigmenent storing. for storing grades
 * 
 *      use: Use in classroom for student grades
 */


import java.util.ArrayList;

public class StudentAssignments {
    
    String name; // student name
    ArrayList<Double> assignmentsGrades;
    static ArrayList<String> assignments = new ArrayList<String>();


    /** Create Student (Master)
     * This will create a new student with
     * the name and init the hashmap
     * 
     * @param name { String } name of student
     */
    public StudentAssignments( String name ) {
        this.name = name;
        this.assignmentsGrades = new ArrayList<Double>();
    }


    /** Create Student (Overloaded)
     * This will create a new student with
     * the name and init the hashmap. With
     * the defualt name `Studenty McStudenton`
     */
    public StudentAssignments() {
        this( "Studenty McStudenton" );
    }

    /** Add assignment
     * This will add an assigment grade and
     * will also update or add the assigment name
     * 
     * 
     * @param name
     * @param grade
     */
    public void addAssignment( String name, double grade ) {
        if ( assignmentsGrades.size() < assignments.size() ) {
            assignments.set( assignmentsGrades.size(), name );
        } else {
            assignments.add( name );
        }
        assignmentsGrades.add( grade );
    }

    /** Print Grade Report
     *  will print a report card for a student.
     */
    public void printGradeReport() {
        String result = name;

        for ( int i = 0; i < assignments.size(); i++ ) {
            result += " " + assignments.get( i ) + " - " + assignmentsGrades.get( i );
        }

        System.out.println( result );
    }

}
