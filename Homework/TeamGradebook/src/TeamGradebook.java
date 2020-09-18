/**
 * 		class: CSSE220
 * 		author: Evan Sellers
 * 		date: 9/17/2020
 * 
 * 		jclass: TeamGradebook
 * 		use: this will deal with linking students
 * 			 and teams togeather. It will allow 
 * 			 teams to have grades and access those
 * 			 teams.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TeamGradebook {

	private ArrayList<Student> students;
	private ArrayList<Team> teams;
	
	/**
	 * Constructor - initializes the fields of TeamGradebook
	 * 
	 * You'll want to be sure you initialize students and teams here.
	 */
	public TeamGradebook() {
		students = new ArrayList<Student>();
		teams    = new ArrayList<Team>();
	}


	/** GET STUDENT (PRIVATE)
	 * Will find a student in the array by the name,
	 * if there is no student with that name will return 
	 * null.
	 * 
	 * 	@param studentName { String } the unique name for the student
	 * 	@return student { Student } instance of student
	 */
	private Student getStudentByName( String studentName ) {
		for ( Student _student : students ) {
			if ( _student.getName().equals( studentName ) ) return _student;
		}
		return null;
	}
	

	/** GET TEAM (PRIVATE)
	 * Will find a team in the array by the name,
	 * if there is no team with that name will return 
	 * null.
	 * 
	 * 	@param teamName { String } the unique name for the team
	 * 	@return team { Team } instance of team
	 */
	private Team getTeamByName( String teamName ) {
		for ( Team _team : teams ) {
			if ( _team.getName().equals( teamName ) ) return _team;
		}
		return null;
	}


	/** CALCULATE AVERAGE (PRIVATE)
	 * 	This will calculate the average of an array list of doubles.
	 * 
	 * @param nums { ArrayList<Double> } list of all numbers to average
	 * @return average { Double } average of the numbers
	 */
	private Double calcAverage( ArrayList<Double> nums ) {
		Double total = 0.0;
		for ( Double num : nums ) {
			total += num;
		}

		return ( total / nums.size() );
	}


	/** ADD STUDENTS (PUBLIC)
	 * 	Creates new instance of Students and adds
	 * 	the new student to the array. If the user
	 * 	already exists will return error.
	 * 
	 * @requires getStudentByName of this => for aquire student instance
	 * 
	 * @param studentName { String } the unique name for the student
	 * @return message { String } message "ok" for success
	 */
	private String handleAddStudent( String studentName ) {
		if ( getStudentByName( studentName ) != null ) return String.format( "fail: user '%s' already exists", studentName );
		students.add( new Student( studentName ) );
		return "ok";
	}


	/** ADD ABSENCE (PUBLIC)
	 * 	Adds an absence to a particular student's record. Will
	 * 	return error message if the user doesn't exists
	 * 
	 * @requires getStudentByName of this => for aquire student instance
	 * 
	 * @param studentName { String } the unique name for the student
	 * @return message { String } message "ok" for success
	 */
	private String handleAddAbsence( String studentName ) {
		Student _student = getStudentByName( studentName );
		if ( _student == null ) return String.format( "fail: user '%s' doesn't exists", studentName );
		_student.addAbsence();
		return "ok";
	}


	/** GET ABSENCE (PUBLIC)
	 * 	Returns a number of absences in a particular
	 * 	student's record. Will return an integer as a 
	 * 	string or a failure message if the user doesn't 
	 * 	exist.
	 * 
	 * @requires getStudentByName of this => for aquire student instance
	 * 
	 * @param studentName { String } the unique name for the student
	 * @return int as String { String } numbers of absences
	 */
	private String handleGetAbsences( String studentName ) {
		Student _student = getStudentByName( studentName );
		if ( _student == null ) return String.format( "fail: user '%s' doesn't exists", studentName );
		return String.valueOf( _student.getAbsence() );
	}


	/** ADD TEAM (PUBLIC)
	 * 	This first check to makes sure that the team
	 * 	name being added doesn't already exist. If the
	 * 	team exists it will return a fail. Then it will
	 * 	check the member list if the student doesn't exist
	 * 	it will add the student. Then it will add the team
	 * 	name to each student. It will then create the team 
	 * 	and add all the users to it.
	 * 
	 * @param teamName { string } the unique name for the team
	 * @param memberNames { ArrayList<String> } a list of student names that belong to the team
	 * @return "ok" if success
	 */
	private String handleAddTeam( String teamName, ArrayList<String> memberNames ) {

		// validate team name doesn't exist
		Team _team = getTeamByName( teamName );
		if ( _team != null ) return String.format( "fail: team '%s' already exists", teamName );

		// validate student and add team
		for ( String studentName : memberNames ) {
			Student _student = getStudentByName( studentName );
			if ( _student == null ) {
				handleAddStudent( studentName );
				_student = getStudentByName( studentName );
			}
			_student.addTeam( teamName );
		}

		// Add Students to team and create team
		teams.add( new Team( teamName, memberNames ) );

		return "ok";
	}


	/** ADD GRADE (PUBLIC)
	 * 	Will add a grade to a specific team. If the 
	 * 	team doesn't exists will return an error.
	 * 
	 * @param teamName { String } the unique name for the team
	 * @param grade { Double } the grade to add
	 * @return "ok" if successful
	 */
	private String handleAddGrade(String teamName, double grade) {
		Team _team = getTeamByName( teamName );
		if ( _team == null ) return String.format( "fail: team '%s' doesn't exists", teamName );
		_team.addGrade( grade );
		return "ok";
	}
	
	
	/** GET STUDENT AVERAGE (PUBLIC)
	 * 	This will first check to make sure the
	 * 	user exists. If so it will get a list of
	 * 	all the teams the user is apart of then 
	 * 	get all those grades and average them.
	 * 
	 * @param studentName { String } the unique name for the student
	 * @return average { String } int as string for student average
	 */
	private String handleGetAverage( String studentName ) {
		Student _student = getStudentByName( studentName );
		if ( _student == null ) return String.format( "fail: user '%s' doesn't exists", studentName );

		ArrayList<Double> grades = new ArrayList<>();
		for ( String teamName : _student.getTeam() ) {
			Team _team = getTeamByName( teamName );
			if ( _team == null ) continue;
			grades.addAll( _team.getGrades() );
		}

		return String.valueOf( ( int ) Math.round( calcAverage( grades ) ) );
	}


	/** BEST TEAM (PUBLIC)
	 * 	Will return a string of the team with the best average
	 * 	grade score. If there are no teams will return an error.
	 * 
	 * @return best team { String } team with best avg score
	 */
	private String handleGetBestTeam() {
		if ( teams.size() == 0 ) return "fail: no teams exist";

		String topTeamName  = "";
		Double topTeamScore = -Double.MAX_VALUE;

		for ( Team _team : teams ) {
			if ( _team.averageGrade() >= topTeamScore ) {
				topTeamName  = _team.getName();
				topTeamScore = _team.averageGrade();
			}
		}

		return topTeamName;
	}

	
	/**
	 * Decodes a command and invokes the right method.
	 * 
	 * THIS METHOD IS WRITTEN FOR YOU - no need to edit
	 * 
	 * You don't have to understand how this function works,
	 * and you don't have to change it.  But it's not that
	 * hard - feel free to figure it out if you like.
	 * 
	 * @param command The command to decode
	 * @return the results of the command.  "ok" if success but no result.
	 */
	public String handleCommand(String command) {
		Scanner input = new Scanner(command);
		String commandType = input.next();
		
		if( commandType.equals( "add-student" ) ) {
			String studentName = input.next();
			input.close();
			return handleAddStudent( studentName );
		}
		
		if( commandType.equals( "add-absence" ) ) {
			String studentName = input.next();
			input.close();
			return handleAddAbsence( studentName );
		}
		
		if( commandType.equals( "get-absences" ) ) {
			String studentName = input.next();
			input.close();
			return handleGetAbsences( studentName );
		}
		
		if( commandType.equals( "add-team" ) ) {
			String teamName = input.next();
			ArrayList<String> memberNames = new ArrayList<String>();
			while( input.hasNext() ) {
				memberNames.add( input.next() );
			}
			input.close();
			return handleAddTeam( teamName, memberNames );
		}
		
		if( commandType.equals( "add-grade" ) ) {
			String teamName = input.next();
			double grade = input.nextDouble();
			input.close();
			return handleAddGrade( teamName, grade );
		}
		
		if( commandType.equals( "get-average" ) ) {
			String studentName = input.next();
			input.close();
			return handleGetAverage( studentName );
		}
		
		if( commandType.equals( "get-best-team" ) ) {
			input.close();
			return handleGetBestTeam();
		}
		
		if( commandType.equals( "exit" ) ) {
			System.exit(0);
		}
		
		input.close();
		return "Unknown command " + commandType;
	}

	/**
	 * 
	 * Run the TeamGradebook in console mode (that is, input is to come from
	 * the console).
	 * 
	 * THIS METHOD IS WRITTEN FOR YOU - no need to edit
	 * 
	 * @param args Command line arguments (ignored)
	 */
	public static void main(String[] args) {
		TeamGradebook book = new TeamGradebook();
		System.out.println( "Welcome to Team gradebook.  Enter commands.  Type 'exit' to end." );
		@SuppressWarnings( "resource" )
		Scanner scanner = new Scanner( System.in );
		while( true ) {
			String commandLine = scanner.nextLine();
			String result = book.handleCommand(commandLine);
			System.out.println(result);
		}
		
	}

}
