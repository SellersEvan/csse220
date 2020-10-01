import java.util.HashMap;

/**
  *  This class is used to demonstrate a functional design
  *  involving Quizzes and Questions which can be updated and displayed
  * 
  */
public class QuizMain {
	

	private HashMap<Integer,Question>   questions;	// the questions
	private HashMap<Integer,Quiz> 	    quizes;		// the quizes


	public QuizMain() {
		this.questions = new HashMap<>();
		this.quizes    = new HashMap<>();
	}
	
	
	
	public static void main(String[] args) {
		//We want to use instance variables of the QuizMain class so we need to construct a QuizMain object
		QuizMain myQuizSimulator = new QuizMain();

		// create dummy questions
		myQuizSimulator.newQuestion( 1, "What is 1x1?" );
		myQuizSimulator.newQuestion( 2, "What is 1x2?" );
		myQuizSimulator.newQuestion( 3, "What is 1x3?" );
		myQuizSimulator.newQuestion( 4, "What is 1x4?" );
		myQuizSimulator.newQuestion( 5, "What is 1x5?" );

		// Create Dummy Quiz
		myQuizSimulator.newQuiz( 1, "Quiz 1" );
		myQuizSimulator.newQuiz( 2, "Quiz 2" );
		myQuizSimulator.newQuiz( 3, "Quiz 3" );

		// One Way to add Question
		myQuizSimulator.addQuestion( 1, 1 );
		myQuizSimulator.addQuestion( 1, 2 );
		myQuizSimulator.addQuestion( 1, 3 );

		myQuizSimulator.addQuestion( 2, 2 );
		myQuizSimulator.addQuestion( 2, 3 );
		myQuizSimulator.addQuestion( 2, 4 );

		// Another Way to add
		myQuizSimulator.getQuiz( 3 ).addQuestion( 5 );

		// These should then fail... and return false
		try {
			if ( myQuizSimulator.addQuestion( 10, 1 )     != false ) throw new Exception( "failed to assert" );	 // quiz doesn't exist
			if ( myQuizSimulator.addQuestion( 1, 10 )     != false ) throw new Exception( "failed to assert" );	 // question doesn't exist
			if ( myQuizSimulator.newQuestion( 1, "test" ) != false ) throw new Exception( "failed to assert" );  // question already exists
			if ( myQuizSimulator.newQuiz( 1, "test" )     != false ) throw new Exception( "failed to assert" );  // quiz already exists
			if ( myQuizSimulator.getQuiz( 100 )           != null  ) throw new Exception( "failed to assert" );  // quiz doesn't exist
			if ( myQuizSimulator.getQuestion( 100 )       != null  ) throw new Exception( "failed to assert" );  // question doesn't exist
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		// 3 Display three or more different quizzes
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more original quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);
		
		
		
		// 4 Change two quiz questions 
		// A. (One should be shared with two or more quizzes)
		// B. (One should be unique to one quiz)
		myQuizSimulator.handleUpdateQuizQuestion( 1,"What is different 1?" );
		myQuizSimulator.handleUpdateQuizQuestion( 2,"What is different 2?" );

		
		// 5 Display the same three (or more) quizzes
		//	   A. One that has a unique question which changed
		//	   B. Two which share a question that has been changed		
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more changed quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);


		// Show removing works
		myQuizSimulator.removeQuestion( 2, 3 );
		System.out.println("--------------------------------------------------");
		System.out.println("Showing removes works:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);

		// Show what's in quiz
		System.out.println("--------------------------------------------------");
		System.out.println("Showing Question display works:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuestions( 2 );
		
	}
	

	/** GET QUIZ (PUBLIC)
	 *  Will return quiz if valid, will retun null
	 *  if not found
	 * 
	 * @param _id { int } the id of quiz
	 * @return { Quiz } the quiz matching
	 */
	public Quiz getQuiz( int _id ) {
		return ( quizes.containsKey( _id ) ) ? quizes.get( _id ) : null;
	}


	/** GET QUESTION (PUBLIC)
	 *  Will return question if valid, will retun null
	 *  if not found
	 * 
	 * @param _id { int } the id of quiz
	 * @return { Question } the question matching
	 */
	public Question getQuestion( int _id ) {
		return ( questions.containsKey( _id ) ) ? questions.get( _id ) : null;
	}


	/** NEW QUIZ (PUBLIC)
	 *  Will add a new quiz. Will return true if success,
	 *  will return false if the _id already exists.
	 * 
	 *  @param _id { int } the id of the quiz
	 *  @param name { String } the name of the quiz
	 *  @return success { boolean } true if success
	 */
	public boolean newQuiz( int _id, String name ) {
		if ( getQuiz( _id ) == null ) {
			this.quizes.put( _id, new Quiz( name ) );
			return true;
		}
		return false;
	}


	/** NEW QUESTION (PUBLIC)
	 *  Will add a new question. Will return true if success,
	 *  will return false if the _id already exists.
	 * 
	 *  @param _id { int } the id of the question
	 *  @param name { String } the name of the question
	 *  @return success { boolean } true if success
	 */
	public boolean newQuestion( int _id, String name ) {
		if ( getQuestion( _id ) == null ) {
			this.questions.put( _id, new Question( name ) );
			return true;
		}
		return false;
	}


	/** ADD QUESTION (PUBLIC)
	 *  Add a question to a quiz. Will return true if
	 *  success and false if the quiz fails to add.
	 * 
	 *  @param quizID { int } the quiz ID
	 *  @param questionID { int } the question ID
	 *  @return { boolean } if success
	 */
	public boolean addQuestion( int quizID, int questionID ) {
		if ( getQuestion( questionID ) == null ) return false;
		if ( getQuiz( quizID ) == null ) return false;

		getQuestion( questionID ).addQuiz( quizID );
		getQuiz( quizID ).addQuestion( questionID );
		return true;
	}


	/** REMOVE QUESTION (PUBLIC)
	 *  Remove a question to a quiz. Will return true if
	 *  success and false if the quiz fails to remove.
	 * 
	 *  @param quizID { int } the quiz ID
	 *  @param questionID { int } the question ID
	 *  @return { boolean } if success
	 */
	public boolean removeQuestion( int quizID, int questionID ) {
		if ( getQuestion( questionID ) == null ) return false;
		if ( getQuiz( quizID ) == null ) return false;

		getQuestion( questionID ).removeQuiz( quizID );
		getQuiz( quizID ).removeQuestion( questionID );
		return true;
	}


	/** UPDATE QUIZ QUESTION (PUBLIC)
	 *  This will get a question and updates it's name.
	 *  If this is successful return true if the id doesn't
	 *  exist return false.
	 * 
	 * @param questionId { int } the id to update
	 * @param questionData { string } the name to update
	 * @return { boolean } if successful
	 */
	public boolean handleUpdateQuizQuestion( int questionId, String questionData ) {
		if ( getQuestion( questionId ) == null ) return false;
		getQuestion( questionId ).setName( questionData );
		return true;
	}


	/** GET QUIZ (PUBLIC)
	 *  This will display which questions has this quiz
	 *  @param quizId { int } the quis id
	 */
	public void handleDisplayQuiz( int quizId ) {
		System.out.println( getQuiz( quizId ).getName() + ": " + quizId );
		for ( Integer questionID : getQuiz( quizId ).getQuestions() )
			System.out.println( "\t" + "Question[" + Integer.toString( questionID ) + "]: " + getQuestion( questionID ).getName() );
	}


	/** GET QUESTIONS (PUBLIC)
	 *  This will display which quizs has this question
	 *  @param questionID { int } the question id
	 */
	public void handleDisplayQuestions( int questionID ) {
		System.out.println( getQuestion( questionID ).getName() + ": " + questionID );
		for ( Integer quizID : getQuestion( questionID ).getQuizes() )
			System.out.println( "\t" + "Quiz[" + Integer.toString( quizID ) + "]: " + getQuiz( quizID ).getName() );
	}

}
