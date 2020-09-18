/**
 * Create instances of StudentAssignments and invoke methods on them.
 * 
 * @author Evan Sellers. Created Dec 9, 2013.
 */
public class StudentAssignmentsMain {

	/**
	 * Program starts here.
	 * 
	 * @param args
	 *            Ignore the args.
	 */
	public static void main(String[] args) {

		
		// TODO: Uncomment this code to get started with StudentAssignments
		
		StudentAssignments one = new StudentAssignments("John Doe");
		StudentAssignments two = new StudentAssignments(); //default name is Studenty McStudenton
		
		one.addAssignment("TwelveProblems", 95);
		two.addAssignment("TwelveProblems", 80);
		
		one.addAssignment("TwelveProblems", 99);
		two.addAssignment("WordGames", 78);
		
		one.addAssignment("TeamGradebook", 92);
		two.addAssignment("Faces", 0);
		
		one.printGradeReport();
		System.out.println(); //blank line
		two.printGradeReport();



		/*
		 * This code should print out:
		 * 
		 * John Doe TwelveProblems - 95.0 WordGames - 99.0 Faces - 92.0
		 * 
		 * Studenty McStudenton TwelveProblems - 80.0 WordGames - 78.0 Faces -
		 * 0.0
		 * 
		 * If you finish early, add a new function to compute the student's
		 * average and print it.
		 */

	}



}
