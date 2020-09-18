/**
 * 		class: CSSE220
 * 		author: Evan Sellers
 * 		date: 9/17/2020
 * 
 * 		jclass: Team
 * 		use: this will create an instance of teams
 * 			 and the information of grades for the 
 * 			 whole team.
 */

import java.util.ArrayList;

public class Team {
	
	private String name; 					// Team Name
	private ArrayList<String> students; 	// Students in the team
	private ArrayList<Double> grades;		// The grades for the team

	/** CONSTRUCTOR (name)
	 * 	This will create an instance with name and it
	 * 	will init students and grades
	 * 
	 * @param newName { String } the name of the team
	 */
	public Team( String newName ) {
		this( newName, null );
	}

	/** CONSTRUCTOR (name,students)
	 * 	This will create an instance with a team name
	 * 	and accept a string with student names.
	 * 
	 * 	@param newName { String } the name of the team
	 * 	@param newStudents { ArrayList<String> } a list of new students to add
	 */
	public Team( String newName, ArrayList<String> newStudents ) {
		this.name     = newName;
		this.students = newStudents;
		this.grades   = new ArrayList<>();
	}


	/** GET NAME (PUBLIC)
	 * 	returns the team name as string
	 * 
	 * @return name { String } Team Name
	 */
	public String getName() {
		return this.name;
	}


	/** ADD STUDENT (PUBLIC)
	 * 	This will add a student to a team. If the student
	 * 	is already in the team, nothing will happen.
	 * 
	 * @param newStudent { String } student name to add
	 */
	public void addStudent( String newStudent ) {
		if ( this.students.contains( newStudent ) ) return;
		this.students.add( newStudent );
	}


	/** GET STUDENTS (PUBLIC)
	 * 	Will return an array of strings of the names
	 * 	of the students that are members of the team.
	 * 
	 * @return students { ArrayList<String> } students that are members
	 */
	public ArrayList<String> getStudents() {
		return this.students;
	}


	/** ADD GRADE (PUBLIC)
	 * 	Will add grades to a team
	 * 
	 * @param newGrade { Double } new grade to add
	 */
	public void addGrade( Double newGrade ) {
		grades.add( newGrade );
	}

	/** GET GRADES (PUBLIC)
	 * 	Will return a list of the grades connected to a team
	 * 
	 * @return grades { ArrayList<Double> } all grades for the team
	 */
	public ArrayList<Double> getGrades() {
		return grades;
	}


	/** TEAM AVERAGE (PUBLIC)
	 * 	Will return the team average for all the grades
	 * 	the team has.
	 * 
	 * @return average { Double } total average of the grades for the team
	 */
	public Double averageGrade() {
		Double total = 0.0;

		for ( Double grade : grades ) {
			total += grade;
		}

		return ( total / grades.size() );
	}

}
