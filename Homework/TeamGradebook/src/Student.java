/**
 * 		class: CSSE220
 * 		author: Evan Sellers
 * 		date: 9/17/2020
 * 
 * 		jclass: Student
 * 		use: this will create an object students
 * 			 for storing basic information on the
 * 			 student and linking them to teams.
 */

import java.util.ArrayList;

public class Student {
	private String name;
	private int absence;
	private ArrayList<String> teams = new ArrayList<String>();
	
	/** CREATE STUDENT (PUBLIC)
	 * This will create a new student and init
	 * their name and absent count to 0.
	 * 
	 * @param newName { String } Name to create for the students
	 */
	public Student( String newName ) {
		this.name = newName;
		this.absence = 0;
	}

	/** GET STUDENT NAME (PUBLIC)
	 * Will return the current set name of
	 * the student.
	 * 
	 * @return { String } Students name
	 */
	public String getName() {
		return name;
	}


	/** ADD ABSENT (PUBLIC)
	 * Will add 1 to the absent record of a student
	 */
	public void addAbsence() {
		absence++;
	}

	/** GET ABSENTS (PUBLIC)
	 * will returns total absents of a student
	 * 
	 * @return { int } total absents of students
	 */
	public int getAbsence() {
		return absence;
	}

	/** ADD TEAM (PUBLIC)
	 * Add a team based on a name
	 * 
	 * @param teamName { String } name of team
	 */
	public void addTeam( String teamName ) {
		teams.add( teamName );
	}

	/** GET TEAM (PUBLIC)
	 * Returns a list of all the team names the
	 * student is apart of
	 * 
	 * @return teams { ArrayList<String> } teams the student is apart of
	 */
	public ArrayList<String> getTeam() {
		return teams;
	}

}
